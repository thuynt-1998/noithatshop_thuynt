package com.doan.student.repository;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity save(CustomerEntity customerEntity);
    CustomerEntity getOne(Long id);
    Boolean existsByCode(String code);
    CustomerEntity findByUserEntityUsername(String username);
    Boolean existsByAccount(String account);
    void deleteByUserEntityUsername(String username);

}
