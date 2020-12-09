package com.doan.student.service.impl;

import com.doan.student.converter.OrderCartConverter;
import com.doan.student.entity.OrderCartEntity;
import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.repository.OrderCartRepository;
import com.doan.student.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCartServices  implements OrderCartService {
    @Autowired
    private OrderCartConverter orderCartConverter;
    @Autowired
    private OrderCartRepository orderCartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public OrderCartDTO saveOrderCart(OrderCartDTO dto, String customer) {
        return existsByCode(dto.getCode())=="true"? orderCartConverter.EntityToDtoAll(orderCartRepository.findByCode(dto.getCode()))
                : orderCartConverter.EntityToDtoAll(orderCartRepository.save(orderCartConverter.DtoToEntity(dto,customerRepository.findByUserEntityUsername(customer))));
    }

    @Override
    public List<OrderCartDTO> getByCustomer(String user) {
        List<OrderCartDTO> list  = new ArrayList<>();
        for (OrderCartEntity entity : orderCartRepository.findByByCustomer(customerRepository.findByUserEntityUsername( user))) {
            list.add(orderCartConverter.EntityToDtoAll(entity));
        }
        return list;
    }

    @Override
    public String existsByCode(String code) {
        return orderCartRepository.existsByCode(code)? "true" : "false";
    }

    @Override
    public List<OrderCartDTO> findByStatus(String status) {
        List<OrderCartDTO> list = new ArrayList<>();
        for(OrderCartEntity entity : orderCartRepository.findByStatus(status))
        {
            list.add(orderCartConverter.EntityToDtoAll(entity));
        }
        return list;
    }

    @Override
    public List<OrderCartDTO> findByStatusAndCustomer(String status, String name) {
        List<OrderCartDTO> list = new ArrayList<>();
        for(OrderCartEntity entity : orderCartRepository.findByByCustomerAndStatus(customerRepository.findByUserEntityUsername( name),status))
        {
            list.add(orderCartConverter.EntityToDtoAll(entity));
        }
        return list;
    }

    @Override
    public OrderCartDTO updateOrderCart(String status, Long id) {
        return orderCartConverter.EntityToDtoAll(orderCartRepository.save(
                orderCartConverter.updateOrderCart(status,orderCartRepository.getOne(id))));
    }
}
