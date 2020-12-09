package com.doan.student.repository;

import com.doan.student.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    RoomEntity save(RoomEntity roomEntity);
    RoomEntity getOne(Long id);
    Boolean existsByCode(String code);
    List<RoomEntity> findAll();

}
