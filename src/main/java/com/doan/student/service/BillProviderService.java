package com.doan.student.service;

import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.response.PageGetData;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface BillProviderService {
    BillProviderDTO saveBillProvider(BillProviderDTO billProviderDTO);
    String existsByCode(String code);
    PageGetData findByProviderId(Long id, Pageable pageable);
    PageGetData findAll(Pageable pageable);
    PageGetData findByStatus(String status, Pageable pageable);
}
