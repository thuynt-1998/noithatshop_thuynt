package com.doan.student.converter;

import com.doan.student.entity.ProviderEntity;
import com.doan.student.payload.dto.ProviderDTO;
import com.doan.student.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public ProviderEntity DtoToEntity(ProviderDTO dto){
        ProviderEntity entity= new ProviderEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setStatus(dto.getStatus());
        return entity;
    }
    public ProviderDTO EntityToDto(ProviderEntity entity){
        ProviderDTO dto= new ProviderDTO() ;
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        dto.setStatus(entity.getStatus());
        return  dto;
    }
}
