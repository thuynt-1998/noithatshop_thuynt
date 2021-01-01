package com.doan.student.repository;

import com.doan.student.entity.ProductDetailEntity;
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
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
    ProductDetailEntity save(ProductDetailEntity productDetailEntity);
    ProductDetailEntity getOne(Long id);
    ProductDetailEntity findFirstByOrderByIdDesc();
    List<ProductDetailEntity> findByProductId(Long id);
    Boolean existsByColors(String code);
    ProductDetailEntity findByColors(String colors);
    ProductDetailEntity findByCode(String code);
    long countByProductCode(String code);
    List<ProductDetailEntity> findByStatus(String status);
    @Modifying(flushAutomatically =  true)
    @Query(value = "update product_detail set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
    @Modifying(flushAutomatically =  true)
    @Query(value = "update product_detail set number_stock=:number where id=:id", nativeQuery = true)
    void updateNumberStock(@Param("id") Long id , @Param("number") BigInteger number);
}
