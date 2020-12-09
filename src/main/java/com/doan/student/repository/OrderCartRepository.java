package com.doan.student.repository;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.OrderCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface OrderCartRepository  extends JpaRepository<OrderCartEntity, Long> {
    OrderCartEntity save(OrderCartEntity entity);
    OrderCartEntity getOne(Long id);
    Boolean existsByCode(String code);
    List< OrderCartEntity> findByByCustomer(CustomerEntity customerEntity);
    List< OrderCartEntity> findByStatus(String status);
    List<OrderCartEntity> findByByCustomerAndStatus(CustomerEntity customerEntity, String status);
    OrderCartEntity findByCode(String code);
}
