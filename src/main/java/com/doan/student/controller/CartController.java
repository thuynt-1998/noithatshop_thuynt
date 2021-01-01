package com.doan.student.controller;

import com.doan.student.payload.dto.CartDTO;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.service.CartServices;
import com.doan.student.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {
    @Autowired
    private CartServices cartServices;
    @Autowired
    private CustomerService customerService;
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("/customer/choose/cart")
    public ResponseEntity<Object> saveCart(@Valid @RequestBody CartDTO dto){
        dto.setCustomer(getCustomer());
        return new ResponseEntity<Object>(cartServices.saveCart(dto), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PutMapping ("/customer/change/cart")
    public ResponseEntity<Object> updateCart(@Valid @RequestBody CartDTO dto){
        return new ResponseEntity<Object>(cartServices.updateCart(dto), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @DeleteMapping("/customer/delete/cart/{id}")
    public ResponseEntity<Object> deleteCart(@PathVariable("id") Long id){
        return new ResponseEntity<Object>(cartServices.deleteCart(id), HttpStatus.OK);
    }
    @GetMapping("/customer/getAll/cart")
    public ResponseEntity<Object> getAll(){

        return new ResponseEntity<Object>(cartServices.getAllCart(getCustomer()), HttpStatus.OK);
    }
    public CustomerDTO getCustomer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  customerService.getCustomerByUsername(authentication.getName());
    }

}
