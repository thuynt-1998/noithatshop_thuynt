package com.doan.student.controller;

import com.doan.student.common.Constant;
import com.doan.student.payload.dto.*;
import com.doan.student.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderCartController {
    @Autowired
    private OrderCartService orderCartService;
    @Autowired
    private OrderCartDetailService orderCartDetailService;
    @Autowired
    private CartServices cartServices;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductDetailService productDetailService;

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("/order/cart")
    @Transactional
    public ResponseEntity<Object> saveCart(@Valid @RequestBody OrderCartDTO dto){
        try{
            dto.setCustomer(getCustomer());
            OrderCartDTO orderCartDTO= orderCartService.saveOrderCart(dto);
            for ( CartDTO cart: dto.getCarts() ) {
                OrderCartDetailDTO dtoDetail= new OrderCartDetailDTO();
                dtoDetail.setPrice(cart.getPrice());
                dtoDetail.setNumber(cart.getNumber());
                dtoDetail.setProduct(cart.getProduct());
                dtoDetail.setOrderCart(orderCartDTO);
                if(cart.getProduct().getProductDetail().get(0).getNumberStock().compareTo(cart.getNumber())==1){
                    orderCartDetailService.saveOrderCartDetail(dtoDetail);
                    productDetailService.updateNumberStock(cart.getProduct().getProductDetail().get(0).getId(), cart.getProduct().getProductDetail().get(0).getNumberStock().subtract(cart.getNumber()));
                    cartServices.deleteCart(cart.getId());
                    return new ResponseEntity<Object>(Constant.YES, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<Object>(Constant.NO, HttpStatus.OK);
                }

            }
            return new ResponseEntity<Object>(Constant.YES, HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity<Object>(Constant.NO, HttpStatus.BAD_REQUEST);
        }

    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PutMapping("/update/order/cart/{id}")
    public ResponseEntity<Object> updateCart(@RequestParam("status") String status, @PathVariable("id") Long id ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return new ResponseEntity<Object>(orderCartService.updateOrderCart(status, id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/getAll/order/cart")
    public ResponseEntity<Object> getByCustomer(){
        return new ResponseEntity<Object>(orderCartService.getByCustomer(getCustomer()), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/get/client/status/order/cart")
    public ResponseEntity<Object> findByStatusAndCustomerList( @RequestParam("status") String status){
        return new ResponseEntity<Object>(orderCartService.findByStatusAndCustomer(status,getCustomer()), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/get/status/order/cart")
    public ResponseEntity<Object> findByStatusList( @RequestParam("status") String status){
        return new ResponseEntity<Object>(orderCartService.findByStatus(status), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getAll/admin/order/cart")
    public ResponseEntity<Object> findAll( ){
        return new ResponseEntity<Object>(orderCartService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/bill/order")
    public ResponseEntity<Object> saveBill(@RequestBody BillOrderCartDTO dto){
        return new ResponseEntity<Object>(orderCartService.saveBill(dto), HttpStatus.OK);
    }


    public CustomerDTO getCustomer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  customerService.getCustomerByUsername(authentication.getName());
    }
}
