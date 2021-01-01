package com.doan.student.controller;

import com.doan.student.payload.dto.RoomDTO;
import com.doan.student.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("admin/save/room")
    public ResponseEntity<Object> create(@Valid @RequestBody RoomDTO roomDTO){
        return new ResponseEntity<Object>(roomService.saveRoom(roomDTO), HttpStatus.OK);
    }
    @GetMapping("/getAll/room")
    public ResponseEntity<List<RoomDTO>> getAllRoom(){
        return new ResponseEntity<List<RoomDTO>>(roomService.getAllRoom(), HttpStatus.OK );
    }

}
