package com.doan.student.service;

import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)

public interface ProductDetailService {
    ProductDetailDTO saveProductDetail(ProductDetailDTO dto, ProductDTO productDTO);
    String existsByCode(String code);
    List<ProductDetailDTO> getProductDetailByProductId(Long id);
}
