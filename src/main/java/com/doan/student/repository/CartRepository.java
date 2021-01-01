package com.doan.student.repository;

import com.doan.student.entity.CartEntity;
import com.doan.student.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface CartRepository  extends JpaRepository<CartEntity, Long> {
    CartEntity save(CartEntity entity);
    CartEntity findFirstByOrderByIdDesc();

    List<CartEntity> findByCustomer(CustomerEntity customer);
    CartEntity findByCustomerCodeAndProductDetailCode(String codeCustomer, String codeDetail);
    Boolean existsByCustomerCodeAndProductDetailCode(String codeCustomer, String codeDetail);

    CartEntity getOne(Long  id);
    Boolean existsByCode(String code);
    CartEntity findByCode(String code);
    @Modifying(flushAutomatically =  true)
    @Query(value = "update cart set number=:number where id=:id", nativeQuery = true)
    void updateCartNumber(@Param("id") Long id , @Param("number") BigInteger number);
}
