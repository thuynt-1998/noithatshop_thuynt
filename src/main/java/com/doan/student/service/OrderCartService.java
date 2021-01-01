package com.doan.student.service;


import com.doan.student.payload.dto.BillOrderCartDTO;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.payload.dto.OrderCartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface OrderCartService {
    OrderCartDTO saveOrderCart(OrderCartDTO dto);
    List<OrderCartDTO> getByCustomer(CustomerDTO user);
    List<OrderCartDTO> getAll();

    String existsByCode(String code);
    List<OrderCartDTO> findByStatus(String status);
    List<OrderCartDTO> findByStatusAndCustomer(String status, CustomerDTO name);
    long countByOrderCartNew();
    String updateOrderCart(String status, Long id);
    BillOrderCartDTO saveBill(BillOrderCartDTO dto);
}
