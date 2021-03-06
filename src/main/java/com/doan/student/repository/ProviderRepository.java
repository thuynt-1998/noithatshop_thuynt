package com.doan.student.repository;

import com.doan.student.entity.ProviderEntity;
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
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
    ProviderEntity save(ProviderEntity providerEntity);
    ProviderEntity getOne(Long id);
    ProviderEntity findByCode(String code);
    Boolean existsByCode(String code);
    Page<ProviderEntity> findByStatus(String status, Pageable pageable);
    ProviderEntity findFirstByOrderByIdDesc();
    @Modifying(flushAutomatically =  true)
    @Query(value = "update provider set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
}
