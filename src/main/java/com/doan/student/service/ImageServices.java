package com.doan.student.service;

import com.doan.student.entity.ImageEntity;
import com.doan.student.payload.dto.ImageDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)

public interface ImageServices {
    String save (ImageDTO dto);
}
