package com.doan.student.service;

import com.doan.student.payload.dto.CartDTO;
import com.doan.student.payload.dto.CustomerDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface CartServices  {
    String saveCart(CartDTO dto);
    String updateCart(CartDTO dto);
    String deleteCart(Long  id);
    List<CartDTO > getAllCart(CustomerDTO account);
    String findByCode(String code);
}
