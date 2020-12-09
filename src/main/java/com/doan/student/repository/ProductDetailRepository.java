package com.doan.student.repository;

import com.doan.student.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
    ProductDetailEntity save(ProductDetailEntity productDetailEntity);
    ProductDetailEntity getOne(Long id);
    List<ProductDetailEntity> findByProductId(Long id);
    Boolean existsByCode(String code);
    ProductDetailEntity findByCode(String code);
}
