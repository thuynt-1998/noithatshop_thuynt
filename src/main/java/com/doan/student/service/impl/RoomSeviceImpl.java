package com.doan.student.service.impl;

import com.doan.student.common.Constant;
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
    public String saveRoom(RoomDTO roomDTO) {

            try{
                String code= Constant.convertCode(roomRepository.findFirstByOrderByIdDesc().getCode(), "RM-");
                roomDTO.setCode(code);
                roomRepository.save(roomConverter.DtoToEntity(roomDTO));
                return  Constant.YES;
            }
            catch (Exception e){
                return Constant.NO;
            }


    }

    @Override
    public List<RoomDTO> getAllRoom() {
        List<RoomDTO> list= new ArrayList<>();
        for (RoomEntity entity : roomRepository.findByStatus(Constant.ACTIVE)) {
            list.add( roomConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public RoomEntity getOne(Long id) {
        return roomRepository.getOne(id);
    }

    @Override
    public String updateStatus(Long id, String status) {
        try{
            roomRepository.updateRoomStatus(id, status);
            return  Constant.YES;
        }
        catch (Exception e){
            return Constant.NO;
        }
    }

    @Override
    public String existsByName(String name) {
        return roomRepository.existsByName(name)? Constant.EXISTS: Constant.NO;
    }


}
