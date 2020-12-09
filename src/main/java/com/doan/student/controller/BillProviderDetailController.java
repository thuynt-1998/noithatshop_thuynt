package com.doan.student.controller;

import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.dto.BillProviderDetailDTO;
import com.doan.student.payload.response.PageGetData;
import com.doan.student.service.BillProviderDetailService;
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
public class BillProviderDetailController {
    @Autowired
    private BillProviderDetailService billProviderDetailService;
    @Autowired
    private BillProviderService billProviderService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/save/bill-provider-detail")
    public ResponseEntity<Object> create(@Valid @RequestBody BillProviderDetailDTO billProviderDetailDTO){
        BillProviderDTO dto= billProviderService.saveBillProvider(billProviderDetailDTO.getBillProviderDTO());
        BillProviderDetailDTO billProviderDetailDTO1= billProviderDetailService.saveBillProviderDetail(billProviderDetailDTO,dto );
        return new ResponseEntity<Object>(billProviderDetailDTO1, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getByBillProvider/bill-provider-detail")
    public PageGetData getByBillProvider(@RequestParam("id") Long id, @PageableDefault(page=0, size=10) Pageable pageable){
        PageGetData page= billProviderDetailService.findByBillProviderId(id, pageable);
        return page;
    }
}
