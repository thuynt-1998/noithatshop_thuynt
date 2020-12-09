package com.doan.student.service.impl;

import com.doan.student.converter.CustomerConverter;
import com.doan.student.entity.CustomerEntity;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Override
    public CustomerDTO getCustomerByUsername(String username) {
        return customerConverter.EntityToDto(customerRepository.findByUserEntityUsername(username));
    }
}
