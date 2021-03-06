package com.doan.student.converter;

import com.doan.student.entity.ProductTypeEntity;
import com.doan.student.entity.RoomEntity;
import com.doan.student.payload.dto.ProductTypeDTO;
import com.doan.student.repository.ProductTypeRepository;
import com.doan.student.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductTypeConverter {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private RoomService roomService;
    public ProductTypeEntity DtoToEntity(ProductTypeDTO dto)
    {
        ProductTypeEntity entity = new ProductTypeEntity();
        entity.setId(dto.getId());
        entity.setCode( dto.getCode());
        entity.setImage( dto.getImage());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        if(dto.getIdRooms()!=null){
            Set<RoomEntity> rooms= new HashSet<>();
            for (Long id: dto.getIdRooms()) {
                rooms.add(roomService.getOne(id));
            }
            entity.setRoom(rooms);
        }
        return entity;
    }
    public ProductTypeDTO EntityToDto  (ProductTypeEntity entity){
        ProductTypeDTO dto = new ProductTypeDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }



}
