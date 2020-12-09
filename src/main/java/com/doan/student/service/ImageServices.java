package com.doan.student.service;

import com.doan.student.entity.ImageEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)

public interface ImageServices {
    ImageEntity save (ImageEntity entity);
}
