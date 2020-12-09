package com.doan.student.converter;

import com.doan.student.entity.ProductEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    private ProductTypeConverter productTypeConverter;
    public ProductEntity DtoToEntity(ProductDTO dto){
        ProductEntity entity=  new ProductEntity();
        entity.setId( dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setSource(dto.getSource());
        entity.setMaterial(dto.getMaterial());
        entity.setSize(dto.getSize());
        entity.setGuarantee(dto.getGuarantee());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setType(productTypeConverter.DtoToEntity(dto.getProductType()));
        return  entity;
    }
    public  ProductDTO EntityToDto(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setMaterial(entity.getMaterial());
        dto.setSize(entity.getSize());
        dto.setSource(entity.getSource());
        dto.setGuarantee(entity.getGuarantee());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setProductType(productTypeConverter.EntityToDto(entity.getType()));
        return dto;
    }
}
