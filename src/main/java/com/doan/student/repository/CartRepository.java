package com.doan.student.repository;

import com.doan.student.entity.CartEntity;
import com.doan.student.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface CartRepository  extends JpaRepository<CartEntity, Long> {
    CartEntity save(CartEntity entity);
//    void deleteInBatch(List<CartEntity> entities);
    List<CartEntity> findByCustomer(CustomerEntity customer);
    CartEntity getOne(Long  id);
    Boolean existsByCode(String code);
    CartEntity findByCode(String code);
}
