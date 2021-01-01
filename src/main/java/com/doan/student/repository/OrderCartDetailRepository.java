package com.doan.student.repository;

import com.doan.student.entity.OrderCartDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface OrderCartDetailRepository  extends JpaRepository<OrderCartDetailEntity , Long> {
    OrderCartDetailEntity save(OrderCartDetailEntity entity);
    OrderCartDetailEntity getOne(Long id);
    OrderCartDetailEntity findFirstByOrderByIdDesc();
    Boolean existsByCode(String code);
    List<OrderCartDetailEntity> findByOrderCartId(Long id);
    OrderCartDetailEntity findByCode(String code);

}
