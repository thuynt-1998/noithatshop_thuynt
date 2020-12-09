package com.doan.student.controller;

import com.doan.student.payload.dto.CartDTO;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.payload.dto.OrderCartDetailDTO;
import com.doan.student.service.CartServices;
import com.doan.student.service.OrderCartDetailService;
import com.doan.student.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @PostMapping("/order/cart")
    public ResponseEntity<Object> saveCart(@Valid @RequestBody OrderCartDTO dto){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String[] time=dtf.format(now).split(" ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        OrderCartDTO orderCartDTO= orderCartService.saveOrderCart(dto, authentication.getName());
        for ( CartDTO cart: dto.getCarts() ) {
            OrderCartDetailDTO dtoDetail= new OrderCartDetailDTO();
            dtoDetail.setCode("ORD"+ dto.getCode()+""+cart.getCode()+time[0]+time[1]);
            dtoDetail.setPrice(cart.getPrice());
            dtoDetail.setNumber(cart.getNumber());
            dtoDetail.setProductDetail(cart.getProductDetail());
            orderCartDetailService.saveOrderCartDetail(dtoDetail, orderCartDTO);
            cartServices.deleteCart(cart);
        }
        return new ResponseEntity<Object>(orderCartDTO, HttpStatus.OK);
    }
    @PutMapping("/update/order/cart/{id}")
    public ResponseEntity<Object> updateCart(@RequestParam("status") String status, @PathVariable("id") Long id ){
        return new ResponseEntity<Object>(orderCartService.updateOrderCart(status, id), HttpStatus.OK);
    }
    @GetMapping("/getAll/order/cart")
    public ResponseEntity<Object> getByCustomer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<Object>(orderCartService.getByCustomer(authentication.getName()), HttpStatus.OK);
    }
    @GetMapping("/getAll/status/order/cart")
    public ResponseEntity<Object> findByStatusAndCustomerList( @RequestParam("status") String status){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<Object>(orderCartService.findByStatusAndCustomer(status, authentication.getName()), HttpStatus.OK);
    }
}
