package com.doan.student.converter;

import com.doan.student.entity.ImageEntity;
import com.doan.student.payload.dto.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {
    @Autowired
    private ProductDetailConverter productDetailConverter;
    public ImageDTO EntityToDto(ImageEntity entity){
        ImageDTO dto = new ImageDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setLink( entity.getLink());
        return dto;
    }
    public ImageEntity DtoToEntity(ImageDTO dto){
        ImageEntity entity = new ImageEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setLink( dto.getLink());
        entity.setProductDetail(productDetailConverter.DtoToEntity(dto.getProductDetail()));
        return entity;
    }
}
