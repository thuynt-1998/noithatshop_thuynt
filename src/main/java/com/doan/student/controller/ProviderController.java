package com.doan.student.controller;

import com.doan.student.payload.dto.ProviderDTO;
import com.doan.student.service.ProviderService;
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
public class ProviderController {
    @Autowired
    private ProviderService providerService;
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/admin/save/provider")
    public ResponseEntity<Object> create(@Valid @RequestBody ProviderDTO providerDTO){
        ProviderDTO providerDTO1= providerService.saveProvider(providerDTO);
        return new ResponseEntity<Object>(providerDTO1, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/admin/getall/provider")
    public ResponseEntity<Object> getAll(@PageableDefault(page=0, size=10)Pageable pageable){

        return new ResponseEntity<Object>(providerService.getAll(pageable), HttpStatus.OK);
    }
}
