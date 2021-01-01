package com.doan.student.repository;

import com.doan.student.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    ImageEntity save(ImageEntity entity);
    @Modifying(flushAutomatically =  true)
    @Query(value = "update image set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);
    ImageEntity findFirstByOrderByIdDesc();
    Boolean existsByLink(String link);
    long countByProductDetailCode(String code);


}
