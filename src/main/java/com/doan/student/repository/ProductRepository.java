package com.doan.student.repository;

import com.doan.student.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity save(ProductEntity productEntity);
    ProductEntity getOne(Long id);
    Boolean existsByCode(String code);
    ProductEntity findByCode(String code);
    List<ProductEntity> findTop10DistinctionByDetailImageIsNotNullOrderByCreatedDateDesc();
    List<ProductEntity> findByTypeId(Long id);

}
