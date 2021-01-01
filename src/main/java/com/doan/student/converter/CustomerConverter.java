package com.doan.student.converter;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    @Autowired
    private UserRepository repository;
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
        entity.setUserEntity(repository.findByUsername(dto.getUsername()).get());
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
