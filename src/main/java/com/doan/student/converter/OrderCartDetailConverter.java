package com.doan.student.converter;

import com.doan.student.entity.OrderCartDetailEntity;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.payload.dto.OrderCartDetailDTO;
import com.doan.student.repository.OrderCartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCartDetailConverter {
    @Autowired
    private ProductDetailConverter productDetailConverter;

    @Autowired
    private OrderCartConverter orderCartConverter;

    public OrderCartDetailDTO EntityToDto(OrderCartDetailEntity entity)
    {
        OrderCartDetailDTO dto =new OrderCartDetailDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setProduct(productDetailConverter.EntityToDtoCart(entity.getProductDetail()));
        dto.setNumber(entity.getNumber());
        dto.setPrice(entity.getPrice());
        return  dto;
    }
    public OrderCartDetailEntity DtoToEntity(OrderCartDetailDTO dto){
        OrderCartDetailEntity entity =  new OrderCartDetailEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setNumber(dto.getNumber());
        entity.setPrice(dto.getPrice());
        entity.setOrderCart(orderCartConverter.DtoToEntity(dto.getOrderCart()));
        entity.setProductDetail(productDetailConverter.DtoToEntityCart(dto.getProduct()));
        return entity;
    }

//    public OrderCartDetailEntity updateEntity(OrderCartDetailDTO dto,  OrderCartDetailEntity entity){
//        entity.setId(dto.getId());
//        entity.setCode(dto.getCode());
//        entity.setNumber(dto.getNumber());
//        entity.setPrice(dto.getPrice());
//        entity.setProductDetail(productDetailConverter.DtoToEntityExistProduct(dto.getProductDetail()));
//        entity.setStatus(dto.getStatus());
//        return entity;
//    }


}
