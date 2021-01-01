package com.doan.student.service;

import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Transactional(rollbackFor = Exception.class)

public interface ProductDetailService {
    ProductDetailDTO saveProductDetail(ProductDetailDTO dto);
    String existsByColors(String code);
    List<ProductDetailDTO> getProductDetailByProductId(Long id);
    String updateStatus(Long id, String status);
    ProductDetailDTO getOne(String color);
    String updateNumberStock(Long id, BigInteger number);
}
