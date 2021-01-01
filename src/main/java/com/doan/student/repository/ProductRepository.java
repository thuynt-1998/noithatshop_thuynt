package com.doan.student.repository;

import com.doan.student.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity save(ProductEntity productEntity);
    ProductEntity getOne(Long id);
    Boolean existsByName(String name);
    Boolean existsByCode(String code);

    ProductEntity findByName(String name);
    ProductEntity findByCode(String code);

    List<ProductEntity> findTop10DistinctionByStatusOrderByCreatedDateDesc(String status);
    List<ProductEntity> findByTypeId(Long id);
    ProductEntity findFirstByOrderByIdDesc();
//    @Modifying(flushAutomatically =  true)
    @Query(value = "update product set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
}
