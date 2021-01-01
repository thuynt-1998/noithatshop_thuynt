package com.doan.student.repository;

import com.doan.student.entity.BillProviderDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface BillProviderDetailRepositoty  extends JpaRepository<BillProviderDetailEntity, Long> {
    BillProviderDetailEntity save(BillProviderDetailEntity entity);
    BillProviderDetailEntity findFirstByOrderByIdDesc();
    Page<BillProviderDetailEntity> findAll(Pageable pageable);
    BillProviderDetailEntity getOne(Long id);
    Boolean existsByCode(String code);
    Page<BillProviderDetailEntity> findByBillProviderId(Long id, Pageable pageable);


    @Modifying(flushAutomatically =  true)
    @Query(value = "update bill_provider_detail set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
}
