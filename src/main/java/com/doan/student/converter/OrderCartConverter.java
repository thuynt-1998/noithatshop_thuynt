package com.doan.student.converter;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.OrderCartDetailEntity;
import com.doan.student.entity.OrderCartEntity;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.payload.dto.OrderCartDetailDTO;
import com.doan.student.repository.OrderCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderCartConverter {
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private OrderCartDetailConverter orderCartDetailConverter;

    public OrderCartDTO EntityToDtoAll(OrderCartEntity entity){
        OrderCartDTO dto= new OrderCartDTO() ;
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setPayments(entity.getPayments());
        dto.setNameCustomer(entity.getNameCustomer());
        dto.setAddress(entity.getAddress());
        dto.setPhoneCustomer(entity.getPhoneCustomer());
        dto.setTransportFree(entity.getTransportFree());
        List<OrderCartDetailDTO> list= new ArrayList<>();
        for ( OrderCartDetailEntity entity1: entity.getOrderCartDetail()) {
            list.add(orderCartDetailConverter.EntityToDto(entity1) );
        }
        dto.setOrderCartDetails(list);// là danh sách các sản phẩm trong giỏ hàng
        dto.setCustomer(customerConverter.EntityToDto( entity.getByCustomer()));
        dto.setNote(entity.getNote());
        dto.setStatus(entity.getStatus());
        return dto;
    }
    public  OrderCartEntity DtoToEntity(OrderCartDTO dto,CustomerEntity customerEntity){
        OrderCartEntity entity = new OrderCartEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setAddress(dto.getAddress());
        entity.setNameCustomer(dto.getNameCustomer());
        entity.setPayments(dto.getPayments());
        entity.setTransportFree(dto.getTransportFree());
        entity.setStatus(dto.getStatus());
        entity.setPhoneCustomer(dto.getPhoneCustomer());
        entity.setByCustomer(customerEntity);
        entity.setNote( dto.getNote());
        return  entity;
    }
    public OrderCartEntity GetDtoToEntity(OrderCartDTO dto){
        OrderCartEntity entity = new OrderCartEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setAddress(dto.getAddress());
        entity.setNameCustomer(dto.getNameCustomer());
        entity.setPayments(dto.getPayments());
        entity.setTransportFree(dto.getTransportFree());
        entity.setStatus(dto.getStatus());
        entity.setPhoneCustomer(dto.getPhoneCustomer());
        entity.setNote( dto.getNote());
        return  entity;
    }
    public  OrderCartEntity updateOrderCart(String status, OrderCartEntity entity){
        entity.setStatus(status);
        return  entity;
    }
}
