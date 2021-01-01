package com.doan.student.service;

import com.doan.student.entity.RoomEntity;
import com.doan.student.payload.dto.RoomDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface RoomService {
    String saveRoom(RoomDTO roomDTO);
    List<RoomDTO> getAllRoom();
    RoomEntity getOne(Long id);
    String updateStatus(Long id, String status);
    String existsByName(String name);
}
