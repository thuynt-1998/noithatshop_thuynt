package com.doan.student.service.impl;

import com.doan.student.converter.ProductConverter;
import com.doan.student.entity.ProductEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.repository.ProductRepository;
import com.doan.student.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;
    @Override
    public ProductDTO saveProduct(ProductDTO dto) {
        return existsByCode(dto.getCode())=="false"? productConverter.EntityToDto(productRepository.save(productConverter.DtoToEntity(dto)))
                : productConverter.EntityToDto(productRepository.findByCode(dto.getCode()));
    }

    @Override
    public String existsByCode(String code) {
        return productRepository.existsByCode(code) ?"true" :"false";
    }

    @Override
    public List<ProductDTO> getAllProductNew() {
        List<ProductEntity> entities= productRepository.findTop10DistinctionByDetailImageIsNotNullOrderByCreatedDateDesc();
        List<ProductDTO> list = new ArrayList<>();
        for (ProductEntity entity: entities){
            list.add(productConverter.EntityToDto(entity));
        }
        return list;
//        List<ProductDTO> list = new ArrayList<>();




    }

    @Override
    public List<ProductDTO> getProductByType(Long id) {
        List<ProductEntity> entities= productRepository.findByTypeId(id);
        List<ProductDTO> list = new ArrayList<>();
        for (ProductEntity entity: entities){
            list.add(productConverter.EntityToDto(entity));
        }
        return list;
    }
}
