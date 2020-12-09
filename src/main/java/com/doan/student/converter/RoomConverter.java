package com.doan.student.converter;

import com.doan.student.entity.RoomEntity;
import com.doan.student.payload.dto.RoomDTO;
import com.doan.student.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ProductTypeConverter productTypeConverter;
    public RoomEntity DtoToEntity(RoomDTO roomDTO){
        RoomEntity entity= new RoomEntity();
        entity.setId(roomDTO.getId());
        entity.setCode(roomDTO.getCode());
        entity.setImage(roomDTO.getImage());
        entity.setName(roomDTO.getName());
        entity.setStatus(roomDTO.getStatus());
        return entity;
    }
    public RoomDTO EntityToDto( RoomEntity entity){
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
