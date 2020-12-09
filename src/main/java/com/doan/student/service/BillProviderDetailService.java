package com.doan.student.service;

import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.dto.BillProviderDetailDTO;
import com.doan.student.payload.response.PageGetData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface BillProviderDetailService {
    BillProviderDetailDTO saveBillProviderDetail(BillProviderDetailDTO billProviderDetailDTO, BillProviderDTO billProviderDTO);
    String existsByCode(String code);
    PageGetData findByBillProviderId(Long id, Pageable pageable);
}
