package com.doan.student.repository;

import com.doan.student.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional(rollbackFor = Exception.class)
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity , Long> {
    Optional<RoleEntity> findByName(String name);
}
