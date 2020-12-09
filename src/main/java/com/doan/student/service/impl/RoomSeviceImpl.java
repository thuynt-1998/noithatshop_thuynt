package com.doan.student.service.impl;

import com.doan.student.converter.RoomConverter;
import com.doan.student.entity.RoomEntity;
import com.doan.student.payload.dto.RoomDTO;
import com.doan.student.repository.RoomRepository;
import com.doan.student.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomSeviceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomConverter roomConverter;
    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) {
        return roomConverter.EntityToDto( roomRepository.save(roomConverter.DtoToEntity(roomDTO)));
    }

    @Override
    public List<RoomDTO> getAllRoom() {
        List<RoomDTO> list= new ArrayList<>();
        for (RoomEntity entity : roomRepository.findAll()) {
            list.add( roomConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public RoomEntity getOne(Long id) {
        return roomRepository.getOne(id);
    }


}
