package com.doan.student.service;

import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.CartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface CartServices  {
    CartDTO saveCart(CartDTO dto, String username);
    CartDTO updateCart(CartDTO dto);
    String deleteCart(CartDTO cartDTOS);
    List<CartDTO > getAllCart(String account);
    String findByCode(String code);
}
