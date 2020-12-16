package com.doan.student.converter;

import com.doan.student.entity.ImageEntity;
import com.doan.student.payload.dto.ImageDTO;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {
    public ImageDTO EntityToDto(ImageEntity entity){
        ImageDTO dto = new ImageDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setLink( entity.getLink());
        dto.setStatus(entity.getStatus());
        return dto;
    }
    public ImageEntity DtoToEntity(ImageDTO dto){
        ImageEntity entity = new ImageEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setLink( dto.getLink());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
