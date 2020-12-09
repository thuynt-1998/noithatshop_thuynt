package com.doan.student.service.impl;

import com.doan.student.entity.ImageEntity;
import com.doan.student.repository.ImageRepository;
import com.doan.student.service.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ImageServicesImpl  implements ImageServices {
    @Autowired
    private ImageRepository repository;
    @Override
    public ImageEntity save(ImageEntity entity) {
        return repository.save(entity);
    }
}
