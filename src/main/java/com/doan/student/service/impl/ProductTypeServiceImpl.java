package com.doan.student.service.impl;

import com.doan.student.common.Constant;
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
    public String saveProductType(ProductTypeDTO productTypeDto) {
            try
            {
                String code= Constant.convertCode(productTypeRepository.findFirstByOrderByIdDesc().getCode(), "PT-");
                productTypeDto.setCode(code);
                 productTypeRepository.save(productTypeConverter.DtoToEntity(productTypeDto));
                 return Constant.YES;
            }
            catch (Exception e){
                return  Constant.NO;
            }
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
        for(ProductTypeEntity entity : productTypeRepository.findByRoomIdAndStatus(id, Constant.ACTIVE))
        {
            list.add(productTypeConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public String existsByName(String name) {
        return productTypeRepository.existsByName(name)? Constant.EXISTS:Constant.NO;
    }

    @Override
    public String updateStatus(Long id, String status) {
        try{
            productTypeRepository.updateRoomStatus(id, status);
            return Constant.YES;
        }
        catch (Exception e){
            return Constant.NO;
        }
    }


}
