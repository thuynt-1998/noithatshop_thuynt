package com.doan.student.service.impl;

import com.doan.student.converter.CustomerConverter;
import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.repository.UserRepository;
import com.doan.student.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomerDTO getCustomerByUsername(String username) {
        return customerConverter.EntityToDto(customerRepository.findByUserEntityUsername(username));
    }

    @Override
    public String ExistsByAccount(String account) {
        return customerRepository.existsByAccount(account) ? "true": "false";
    }

    @Override
    public String deleteCustomer(String username) {
        customerRepository.deleteByUserEntityUsername(username);
        return "true";
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        UserEntity entity= userRepository.findByUsername(customerDTO.getUsername()).get();

        return customerConverter.EntityToDto(customerRepository.save(customerConverter.updateEntity(customerDTO, entity))) ;
    }


}
