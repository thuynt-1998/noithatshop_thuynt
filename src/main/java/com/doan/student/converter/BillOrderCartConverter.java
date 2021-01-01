package com.doan.student.converter;

import com.doan.student.entity.BillOrderCartEntity;
import com.doan.student.payload.dto.BillOrderCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillOrderCartConverter {
    @Autowired
    private OrderCartConverter orderCartConverter;

    public BillOrderCartDTO EntityToDto(BillOrderCartEntity entity){
        BillOrderCartDTO dto = new BillOrderCartDTO();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setAmount(entity.getAmountCustomer());
        dto.setOrderCart(orderCartConverter.EntityToDtoResponse(entity.getOrderCart()));
        dto.setCreateDate(entity.getCreatedDate());
        return dto;
    }
    public BillOrderCartEntity DtoToEntity(BillOrderCartDTO dto){
        BillOrderCartEntity entity = new BillOrderCartEntity() ;
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setAmountCustomer(dto.getAmount());
        entity.setOrderCart(orderCartConverter.DtoToEntity(dto.getOrderCart()));
        return entity;
    }
}
