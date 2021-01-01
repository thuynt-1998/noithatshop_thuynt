package com.doan.student.controller;

import com.doan.student.payload.dto.OrderCartDetailDTO;
import com.doan.student.service.OrderCartDetailService;
import com.doan.student.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderCartDetailController {
    @Autowired
    private OrderCartDetailService orderCartDetailService;
    @Autowired
    private OrderCartService orderCartService;
    @PutMapping("/update/order/cart/detail")
    public ResponseEntity<Object> updateCart(@Valid @RequestBody OrderCartDetailDTO dto){
        return new ResponseEntity<Object>("", HttpStatus.OK);
    }
}

