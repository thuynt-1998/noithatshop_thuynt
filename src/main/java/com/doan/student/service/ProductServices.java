package com.doan.student.service;

import com.doan.student.payload.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)

public interface ProductServices {
    ProductDTO saveProduct(ProductDTO dto);
    String existsByCode(String code);
    List<ProductDTO> getAllProductNew();
}
