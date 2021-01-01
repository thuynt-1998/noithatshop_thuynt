package com.doan.student.repository;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity save(CustomerEntity customerEntity);
    CustomerEntity getOne(Long id);
    Boolean existsByCode(String code);
    CustomerEntity findByUserEntityUsername(String username);
    Boolean existsByAccount(String account);
    void deleteByUserEntityUsername(String username);
    @Query(value = "update customer set name=:name, address= :address, account=:account, date_of_birth=:date, gender=:gender where id=:id", nativeQuery = true)
    void updateInfoCustomer(@Param("name") String name, @Param("address") String address, @Param("account") String account, @Param("date")Date date, @Param("gender") String gender, @Param("id") Long id);


}
