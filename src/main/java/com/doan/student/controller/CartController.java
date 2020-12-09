package com.doan.student.controller;

import com.doan.student.payload.dto.CartDTO;
import com.doan.student.service.CartServices;
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
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("/customer/choose/cart")
    public ResponseEntity<Object> saveCart(@Valid @RequestBody CartDTO dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<Object>(cartServices.saveCart(dto, authentication.getName()), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PutMapping ("/customer/change/cart")
    public ResponseEntity<Object> updateCart(@Valid @RequestBody CartDTO dto){
        return new ResponseEntity<Object>(cartServices.updateCart(dto), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @DeleteMapping("/customer/delete/cart")
    public ResponseEntity<Object> deleteCart(@RequestBody CartDTO dtos){
        return new ResponseEntity<Object>(cartServices.deleteCart(dtos), HttpStatus.OK);
    }
    @GetMapping("/customer/getAll/cart")
    public ResponseEntity<Object> getAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return new ResponseEntity<Object>(cartServices.getAllCart(authentication.getName()), HttpStatus.OK);
    }

}
