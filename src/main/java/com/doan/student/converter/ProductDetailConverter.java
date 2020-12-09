package com.doan.student.converter;

import com.doan.student.entity.ProductDetailEntity;
import com.doan.student.entity.ProductEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import com.doan.student.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDetailConverter {

    @Autowired
    private  ProductConverter productConverter;
    public ProductDetailEntity DtoToEntity(ProductDetailDTO dto , ProductDTO productDTO){
        ProductDetailEntity entity=  new ProductDetailEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setColors(dto.getColors());
        entity.setProductPrice(dto.getProductPrice());
        entity.setRealPrice(dto.getRealPrice());
        entity.setNumberStock(dto.getNumberStock());
        entity.setStatus(dto.getStatus());
        entity.setProduct(productConverter.DtoToEntity(productDTO));
        return entity;

    }
    public ProductDetailEntity DtoToEntityExistProduct(ProductDetailDTO dto ){
        ProductDetailEntity entity=  new ProductDetailEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setColors(dto.getColors());
        entity.setProductPrice(dto.getProductPrice());
        entity.setRealPrice(dto.getRealPrice());
        entity.setNumberStock(dto.getNumberStock());
        entity.setStatus(dto.getStatus());
        entity.setProduct(productConverter.DtoToEntity(dto.getProduct()));
        return entity;

    }
    public ProductDetailDTO EntityToDto (ProductDetailEntity entity){
        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setColors(entity.getColors());
        dto.setNumberStock(entity.getNumberStock());
        dto.setProductPrice(entity.getProductPrice());
        dto.setRealPrice(entity.getRealPrice());
        dto.setStatus(entity.getStatus());
        dto.setProduct(productConverter.EntityToDto(entity.getProduct()));
        return dto;
    }
    public ProductDetailDTO EntityToDtoNoProduct(ProductDetailEntity entity){
        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setColors(entity.getColors());
        dto.setNumberStock(entity.getNumberStock());
        dto.setProductPrice(entity.getProductPrice());
        dto.setRealPrice(entity.getRealPrice());
        dto.setStatus(entity.getStatus());
        return dto;
    }




}
