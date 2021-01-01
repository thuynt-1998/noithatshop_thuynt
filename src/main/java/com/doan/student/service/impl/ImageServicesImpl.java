package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.converter.ImageConverter;
import com.doan.student.entity.ImageEntity;
import com.doan.student.payload.dto.ImageDTO;
import com.doan.student.repository.ImageRepository;
import com.doan.student.service.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ImageServicesImpl  implements ImageServices {
    @Autowired
    private ImageRepository repository;
    @Autowired
    private ImageConverter converter;
    @Override
    public String save(ImageDTO dto)
    {
        try{
            if(!repository.existsByLink(dto.getLink())){
                String code= Constant.convertCode(repository.findFirstByOrderByIdDesc().getCode(),"IM-");
                repository.save(converter.DtoToEntity(dto));
            }
            return Constant.YES;
        }
        catch (Exception e){
            return  Constant.NO;
        }
    }
}
