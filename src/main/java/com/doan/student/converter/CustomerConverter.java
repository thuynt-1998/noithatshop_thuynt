package com.doan.student.converter;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.payload.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public CustomerDTO EntityToDto(CustomerEntity entity){
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setAccount(entity.getAccount());
        dto.setUsername(entity.getUserEntity().getUsername());
        dto.setGender(entity.getGender());
        dto.setDateOfBirth(entity.getDateOfBirth());
        return dto;
    }
    public CustomerEntity DtoToEntity(CustomerDTO dto){
        CustomerEntity entity= new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAccount(dto.getAccount());
        entity.setGender(dto.getGender());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAddress(dto.getAddress());
        entity.setCode(dto.getCode());
        return entity;
    }
    public CustomerEntity DtoToEntityExists(CustomerDTO dto, CustomerEntity entity){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAccount(dto.getAccount());
        entity.setGender(dto.getGender());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAddress(dto.getAddress());
        entity.setCode(dto.getCode());
        return entity;
    }
}
