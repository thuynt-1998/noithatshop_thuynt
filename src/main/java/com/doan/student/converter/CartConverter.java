package com.doan.student.converter;

import com.doan.student.entity.CartEntity;
import com.doan.student.entity.CustomerEntity;
import com.doan.student.payload.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {
    @Autowired
    private ProductDetailConverter productDetailConverter;

    @Autowired
    private CustomerConverter customerConverter;
    public CartEntity DtoToEntity(CartDTO dto){
        CartEntity entity = new CartEntity();
        entity.setId( dto.getId());
        entity.setCode(dto.getCode());
        entity.setNumber(dto.getNumber());
        entity.setPrice(dto.getPrice());
        entity.setProductDetail(productDetailConverter.DtoToEntityCart(dto.getProduct()) );
        entity.setCustomer(customerConverter.DtoToEntity(dto.getCustomer())) ;
        return entity;
    }
    public  CartDTO EntityToDto(CartEntity entity){
        CartDTO dto =new CartDTO();
        dto.setId( entity.getId());
        dto.setCode(entity.getCode());
        dto.setNumber(entity.getNumber());
        dto.setPrice(entity.getPrice());
        dto.setProduct(productDetailConverter.EntityToDtoCart( entity.getProductDetail()));
        dto.setCustomer(customerConverter.EntityToDto( entity.getCustomer()));
        return dto;

    }

}
