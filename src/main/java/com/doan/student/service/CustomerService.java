package com.doan.student.service;

import com.doan.student.payload.dto.CustomerDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)

public interface CustomerService {
    CustomerDTO getCustomerByUsername(String username);
    String ExistsByAccount(String account);
    String deleteCustomer(String username);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
}
