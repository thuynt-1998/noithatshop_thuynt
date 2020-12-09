package com.doan.student.controller;


import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.response.PageGetData;
import com.doan.student.service.BillProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin")
public class BillProviderController {
    @Autowired
    private BillProviderService billProviderService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/save/bill-provider")
    public ResponseEntity<Object> create(@Valid @RequestBody BillProviderDTO billProviderDTO){
        BillProviderDTO billProviderDTO1= billProviderService.saveBillProvider(billProviderDTO);
        return new ResponseEntity<Object>(billProviderDTO1, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getByProviderId/bill-provider")
    public PageGetData getByProviderId(@RequestParam Long id, @PageableDefault(page=0, size=10)Pageable pageable){
        return billProviderService.findByProviderId(id, pageable);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getAll/bill-provider")
    public PageGetData getAll(@PageableDefault(page=0, size=10)Pageable pageable){
        return billProviderService.findAll( pageable);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getByCode/bill-provider")
    public PageGetData getByStatus(@RequestParam String status, @PageableDefault(page=0, size=10)Pageable pageable){
        return billProviderService.findByStatus(status, pageable);
    }

}
