package com.doan.student.service;

import com.doan.student.payload.dto.ProductTypeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface ProductTypeServices {
    ProductTypeDTO saveProductType(ProductTypeDTO productTypeDto);
    List<ProductTypeDTO> getAllProductType();
    List<ProductTypeDTO> getProductTypeByRoomId(Long id);
    String existsByCode(String code);
}
