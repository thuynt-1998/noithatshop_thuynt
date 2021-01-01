package com.doan.student.repository;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.OrderCartEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface OrderCartRepository  extends JpaRepository<OrderCartEntity, Long> {
    OrderCartEntity save(OrderCartEntity entity);
    OrderCartEntity getOne(Long id);
    OrderCartEntity findFirstByOrderByIdDesc();
    Boolean existsByCode(String code);
    long countByStatusContains(String status);
    OrderCartEntity findByCode(String code);

    List< OrderCartEntity> findByByCustomer(CustomerEntity customer);
    List< OrderCartEntity> findByStatusContains(String status);
    List< OrderCartEntity> findByOrderByModifiedDateDesc();

    List<OrderCartEntity> findByByCustomerAndStatusContains(CustomerEntity customer, String status);

    Page<OrderCartEntity> findByStatusContains(String status, Pageable pageable);

    @Modifying(flushAutomatically =  true)
    @Query(value = "update order_cart set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);

}
