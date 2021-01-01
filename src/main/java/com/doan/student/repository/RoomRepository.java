package com.doan.student.repository;

import com.doan.student.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    RoomEntity save(RoomEntity roomEntity);
    RoomEntity getOne(Long id);
    Boolean existsByName(String code);
    List<RoomEntity> findAll();
    List<RoomEntity> findByStatus(String status);
    RoomEntity findFirstByOrderByIdDesc();
    @Modifying(flushAutomatically =  true)
    @Query(value = "update room set status=:status where id=:id", nativeQuery = true)
    void updateRoomStatus(@Param("id") Long id , @Param("status") String status);

}
