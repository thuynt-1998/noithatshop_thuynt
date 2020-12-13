package com.doan.student.service.impl;

import com.doan.student.converter.ProductDetailConverter;
import com.doan.student.entity.ProductDetailEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import com.doan.student.repository.ProductDetailRepository;
import com.doan.student.repository.ProductRepository;
import com.doan.student.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailConverter productDetailConverter;
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetailDTO saveProductDetail(ProductDetailDTO dto, ProductDTO productDTO) {
        return existsByCode(dto.getCode()) =="false"? productDetailConverter.EntityToDto(productDetailRepository.save(productDetailConverter.DtoToEntity(dto, productDTO)))
                : productDetailConverter.EntityToDto(productDetailRepository.findByCode(dto.getCode()));
    }

    @Override
    public String existsByCode(String code) {
        return productDetailRepository.existsByCode(code) ?"true":"false";
    }

    @Override
    public List<ProductDetailDTO> getProductDetailByProductId(Long id) {
        List<ProductDetailDTO> list = new ArrayList<>();
        List<ProductDetailEntity> entities = productDetailRepository.findByProductId(id);
        for (ProductDetailEntity entity : entities){
            list.add(productDetailConverter.EntityToDto(entity));
        }

        return list;
    }
}
