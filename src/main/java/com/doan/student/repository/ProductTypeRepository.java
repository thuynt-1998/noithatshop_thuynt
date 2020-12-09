package com.doan.student.repository;

import com.doan.student.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {
    ProductTypeEntity save(ProductTypeEntity productTypeEntity);
    ProductTypeEntity getOne(Long id);
    Boolean existsByCode(String code);
    List<ProductTypeEntity> findByRoomId(Long id);
    ProductTypeEntity findByCode(String code);

}
