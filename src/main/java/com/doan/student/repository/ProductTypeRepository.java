package com.doan.student.repository;

import com.doan.student.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {
    ProductTypeEntity save(ProductTypeEntity productTypeEntity);
    ProductTypeEntity getOne(Long id);
    Boolean existsByName(String code);
    List<ProductTypeEntity> findByRoomId(Long id);
    ProductTypeEntity findByCode(String code);
    ProductTypeEntity findFirstByOrderByIdDesc();
    List<ProductTypeEntity> findByRoomIdAndStatus(Long id, String status);

    @Modifying(flushAutomatically =  true)
    @Query(value = "update product_type set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
}
