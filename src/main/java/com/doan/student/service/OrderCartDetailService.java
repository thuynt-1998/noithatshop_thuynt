package com.doan.student.service;

import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.payload.dto.OrderCartDetailDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface OrderCartDetailService {
    String saveOrderCartDetail(OrderCartDetailDTO dto);
    String existsByCode(String code);

}
