package com.doan.student.service;

import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.OrderCartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface OrderCartService {
    OrderCartDTO saveOrderCart(OrderCartDTO dto, String user);
    List<OrderCartDTO> getByCustomer(String user);
    String existsByCode(String code);
    List<OrderCartDTO> findByStatus(String status);
    List<OrderCartDTO> findByStatusAndCustomer(String status, String name);

    OrderCartDTO updateOrderCart(String status, Long id);

}
