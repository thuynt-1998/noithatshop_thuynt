package com.doan.student.service;

import com.doan.student.payload.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)

public interface ProductServices {
    ProductDTO saveProduct(ProductDTO dto);
    String existsByName(String code);
    String existsByCode(String code);
    List<ProductDTO> getAllProductNew();
    List<ProductDTO> getProductByType(Long id);
    String updataStatus(Long id, String status);
    String updateProduct(ProductDTO dto);
    ProductDTO findByName(String name);
}
