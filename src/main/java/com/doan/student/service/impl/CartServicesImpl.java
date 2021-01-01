package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.converter.CartConverter;
import com.doan.student.converter.CustomerConverter;
import com.doan.student.entity.CartEntity;
import com.doan.student.entity.CustomerEntity;
import com.doan.student.payload.dto.CartDTO;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.repository.CartRepository;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.service.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
    @Autowired
    private CustomerConverter customerConverter;
    @Override
    public String saveCart(CartDTO dto) {
        if(repository.existsByCustomerCodeAndProductDetailCode(dto.getCustomer().getCode(), dto.getProduct().getProductDetail().get(0).getCode()))
        {
            CartEntity entity = repository.findByCustomerCodeAndProductDetailCode(dto.getCustomer().getCode(), dto.getProduct().getProductDetail().get(0).getCode());

            repository.updateCartNumber(entity.getId(), entity.getNumber().add(dto.getNumber()));
            return Constant.EXISTS;
        }
        else{
            if(repository.findAll().isEmpty()){
                dto.setCode("CR-00001");
            }
            else{
                String code= Constant.convertCode(repository.findFirstByOrderByIdDesc().getCode(), "CR-");
                dto.setCode(code);

            }
            repository.save(cartConverter.DtoToEntity(dto));
            return Constant.YES;
        }


    }

    @Override
    public String updateCart(CartDTO dto) {
        try {
            repository.updateCartNumber(dto.getId(), dto.getNumber());
            return  Constant.YES;
        }
        catch (Exception e){
            return Constant.NO;
        }
    }

    @Override
    public String deleteCart(Long id) {
        try{
            repository.deleteById(id);
            return Constant.YES;
        }
        catch (Exception e){
            return  Constant.NO;
        }
    }

    @Override
    public List<CartDTO> getAllCart(CustomerDTO account) {
        List<CartDTO> dtos = new ArrayList<>();
        for ( CartEntity entity: repository.findByCustomer(customerConverter.DtoToEntity( account))) {
            dtos.add(cartConverter.EntityToDto(entity));
        }
        return dtos;
    }

    @Override
    public String findByCode(String code) {
        return repository.existsByCode(code)? "true": "false";
    }
}
