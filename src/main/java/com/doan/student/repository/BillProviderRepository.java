package com.doan.student.repository;

import com.doan.student.entity.BillProviderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface BillProviderRepository  extends JpaRepository<BillProviderEntity,Long>
{
    BillProviderEntity save(BillProviderEntity billProviderEntity);
    BillProviderEntity getOne(Long id);
    BillProviderEntity findByCode(String code);
    Boolean existsByCode(String code);
    Page<BillProviderEntity> findAll(Pageable pageable);
    Page<BillProviderEntity> findByStatus(String status, Pageable pageable);
    Page<BillProviderEntity> findByProviderId(Long id, Pageable pageable);
}
