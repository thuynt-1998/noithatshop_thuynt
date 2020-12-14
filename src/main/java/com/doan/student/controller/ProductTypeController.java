package com.doan.student.controller;

import com.doan.student.payload.dto.ProductTypeDTO;
import com.doan.student.service.ProductTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductTypeController {
    @Autowired
    private ProductTypeServices productTypeServices;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/admin/save/product-type")
    public ResponseEntity<Object> create(@Valid @RequestBody ProductTypeDTO productTypeDto){
        ProductTypeDTO roomDTO1= productTypeServices.saveProductType(productTypeDto);
        return new ResponseEntity<Object>(roomDTO1, HttpStatus.OK);
    }
    @GetMapping("/admin/getAll/product-type")
    public ResponseEntity<List<ProductTypeDTO>> getAllRoom(){
        return new ResponseEntity<List<ProductTypeDTO>>(productTypeServices.getAllProductType(), HttpStatus.OK );
    }
    @GetMapping("/getByRoomId/product-type")
    public ResponseEntity<List<ProductTypeDTO>> getByRoomId(@RequestParam("id") Long id){
        return new ResponseEntity<List<ProductTypeDTO>>(productTypeServices.getProductTypeByRoomId(id), HttpStatus.OK );
    }

}
