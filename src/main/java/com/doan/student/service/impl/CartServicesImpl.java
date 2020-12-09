package com.doan.student.service.impl;

import com.doan.student.converter.CartConverter;
import com.doan.student.entity.CartEntity;
import com.doan.student.payload.dto.CartDTO;
import com.doan.student.repository.CartRepository;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.service.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServicesImpl implements CartServices {
    @Autowired
    private CartConverter cartConverter;
    @Autowired
    private CartRepository repository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CartDTO saveCart(CartDTO dto, String username) {

        return findByCode(dto.getCode())=="true"? cartConverter.EntityToDto(repository.findByCode(dto.getCode()))
                : cartConverter.EntityToDto(repository.save(cartConverter.DtoToEntity(dto,customerRepository.findByUserEntityUsername(username))));
    }

    @Override
    public CartDTO updateCart(CartDTO dto) {
        return cartConverter.EntityToDto(repository.save(cartConverter.updateEntity(dto, repository.getOne(dto.getId()))));
    }

    @Override
    public String deleteCart(CartDTO cartDTO) {
        repository.delete(cartConverter.updateEntity(cartDTO, new CartEntity()));
        return "true";
    }

    @Override
    public List<CartDTO> getAllCart(String account) {
        List<CartDTO> dtos = new ArrayList<>();
        for ( CartEntity entity: repository.findByCustomer(customerRepository.findByUserEntityUsername(account))) {
            dtos.add(cartConverter.EntityToDto(entity));
        }
        return dtos;
    }

    @Override
    public String findByCode(String code) {
        return repository.existsByCode(code)? "true": "false";
    }
}
