package com.doan.student.controller;

import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/admin/save/product")
    public ResponseEntity<Object> create(@Valid @RequestBody ProductDTO productDto){
        ProductDTO productDTO= productServices.saveProduct(productDto);
        return new ResponseEntity<Object>(productDTO, HttpStatus.OK);
    }
    @GetMapping("/admin/getnew/product")
    public ResponseEntity<Object> getProductNew(){
        return new ResponseEntity<Object>(productServices.getAllProductNew(), HttpStatus.OK);
    }
    @GetMapping("/getbytype/product/{id}")
    public ResponseEntity<Object> getProductByTypeId( @PathVariable ("id") Long id){
        return new ResponseEntity<Object>(productServices.getProductByType(id), HttpStatus.OK);
    }
}
