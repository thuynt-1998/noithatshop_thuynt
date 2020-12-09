package com.doan.student.service.impl;

import com.doan.student.converter.ProductTypeConverter;
import com.doan.student.entity.ProductTypeEntity;
import com.doan.student.payload.dto.ProductTypeDTO;
import com.doan.student.repository.ProductTypeRepository;
import com.doan.student.service.ProductTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductTypeServiceImpl implements ProductTypeServices {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductTypeConverter productTypeConverter;
    @Override
    public ProductTypeDTO saveProductType(ProductTypeDTO productTypeDto) {
        return existsByCode(productTypeDto.getCode())=="false" ? productTypeConverter.EntityToDto(productTypeRepository.save(productTypeConverter.DtoToEntity(productTypeDto)))
                :productTypeDto;
    }

    @Override
    public List<ProductTypeDTO> getAllProductType() {
        List<ProductTypeDTO> list= new ArrayList<>();
        for (ProductTypeEntity entity : productTypeRepository.findAll()) {
            list.add(productTypeConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public List<ProductTypeDTO> getProductTypeByRoomId(Long id) {
        List<ProductTypeDTO> list =new ArrayList<>();
        for(ProductTypeEntity entity : productTypeRepository.findByRoomId(id))
        {
            list.add(productTypeConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public String existsByCode(String code) {
        return productTypeRepository.existsByCode(code)? "true":"false";
    }


}
