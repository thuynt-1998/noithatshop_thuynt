package com.doan.student.converter;

import com.doan.student.entity.BillProviderEntity;
import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.repository.BillProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillProviderConverter {

    @Autowired
    private ProviderConverter providerConverter;

    public BillProviderDTO EntityToDto(BillProviderEntity entity){
        BillProviderDTO dto= new BillProviderDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setTotalPrice(entity.getTotalPrice());
        dto.setTotalNumber(entity.getTotalNumber());
        dto.setStatus(entity.getStatus());
        dto.setProviderDTO(providerConverter.EntityToDto(entity.getProvider()));
        return dto;
    }
    public BillProviderEntity DtoToEntity(BillProviderDTO dto){
        BillProviderEntity entity=  new BillProviderEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setTotalNumber(dto.getTotalNumber());
        entity.setStatus(dto.getStatus());
        entity.setProvider(providerConverter.DtoToEntity(dto.getProviderDTO()));
        return entity;
    }
}
