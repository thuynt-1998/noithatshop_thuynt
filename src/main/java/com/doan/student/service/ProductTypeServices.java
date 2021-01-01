package com.doan.student.service;

import com.doan.student.payload.dto.ProductTypeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface ProductTypeServices {
    String saveProductType(ProductTypeDTO productTypeDto);
    List<ProductTypeDTO> getAllProductType();
    List<ProductTypeDTO> getProductTypeByRoomId(Long id);
    String existsByName(String code);
    String updateStatus(Long id, String status);
}
