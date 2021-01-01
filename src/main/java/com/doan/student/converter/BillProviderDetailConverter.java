package com.doan.student.converter;

import com.doan.student.entity.BillProviderDetailEntity;
import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.dto.BillProviderDetailDTO;
import com.doan.student.repository.BillProviderDetailRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillProviderDetailConverter {
    @Autowired
    private BillProviderConverter billProviderConverter;
    @Autowired
    private ProductDetailConverter productDetailConverter;
    public BillProviderDetailDTO EntityToDto(BillProviderDetailEntity entity){
        BillProviderDetailDTO dto= new BillProviderDetailDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setPrice(entity.getPrice());
        dto.setNumber(entity.getNumber());
        dto.setBillProviderDTO(billProviderConverter.EntityToDto(entity.getBillProvider()));
        dto.setProductDetail(productDetailConverter.EntityToDtoResponse(entity.getProductDetail()));
        return dto;
    }
    public  BillProviderDetailEntity DtoToEntity(BillProviderDetailDTO dto, BillProviderDTO billProviderDTO){
        BillProviderDetailEntity entity= new BillProviderDetailEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setNumber(dto.getNumber());
        entity.setPrice(dto.getPrice());

        entity.setBillProvider(billProviderConverter.DtoToEntity(billProviderDTO));
        entity.setProductDetail(productDetailConverter.DtoToEntity(dto.getProductDetail()));
        return entity;
    }
    public BillProviderDetailEntity DtoToEntityExists(BillProviderDetailDTO dto, BillProviderDetailEntity entity)
    {
        entity.setNumber(dto.getNumber());
        entity.setPrice(dto.getPrice());
        return entity;

    }
}
