package com.doan.student.service.impl;

import com.doan.student.converter.OrderCartDetailConverter;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.payload.dto.OrderCartDetailDTO;
import com.doan.student.repository.OrderCartDetailRepository;
import com.doan.student.service.OrderCartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCartDetailServiceImpl implements OrderCartDetailService
{
    @Autowired
    private OrderCartDetailRepository repository;
    @Autowired
    private OrderCartDetailConverter converter;
    @Override
    public OrderCartDetailDTO saveOrderCartDetail(OrderCartDetailDTO dto, OrderCartDTO dtoOrder) {
        return existsByCode(dto.getCode()) =="true"?converter.EntityToDto(repository.findByCode(dto.getCode()))
                : converter.EntityToDto(repository.save(converter.DtoToEntity(dto, dtoOrder)));
    }

    @Override
    public String existsByCode(String code) {
        return repository.existsByCode(code)?"true": "false";
    }

    @Override
    public OrderCartDetailDTO updateOrderCart(OrderCartDetailDTO dto) {
        return converter.EntityToDto(repository.save(converter.updateEntity(dto, repository.getOne(dto.getId()))));
    }
}
