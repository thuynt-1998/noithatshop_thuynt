package com.doan.student.repository;

import com.doan.student.entity.BillProviderEntity;
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
public interface BillProviderRepository  extends JpaRepository<BillProviderEntity,Long>
{
    BillProviderEntity save(BillProviderEntity billProviderEntity);
    BillProviderEntity getOne(Long id);
    BillProviderEntity findByCode(String code);
    BillProviderEntity findFirstByOrderByIdDesc();

    Boolean existsByCode(String code);

    Page<BillProviderEntity> findAll(Pageable pageable);
    Page<BillProviderEntity> findByStatus(String status, Pageable pageable);
    Page<BillProviderEntity> findByProviderId(Long id, Pageable pageable);
    @Modifying(flushAutomatically =  true)
    @Query(value = "update bill_provider set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
}
