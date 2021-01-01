package com.doan.student.repository;

import com.doan.student.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    UserEntity save(UserEntity userEntity);
    UserEntity getOne(Long id);
    void deleteByUsername(String username);
    UserEntity findFirstByOrderByIdDesc();
    @Modifying(flushAutomatically = true)
    @Query(value = "update user_shop set password=:password where id=:id", nativeQuery = true)
    void updateUserPaaword(@Param("id") Long id, @Param("password") String password);
}
