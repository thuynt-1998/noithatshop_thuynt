package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.converter.OrderCartDetailConverter;
import com.doan.student.payload.dto.OrderCartDTO;
import com.doan.student.payload.dto.OrderCartDetailDTO;
import com.doan.student.repository.OrderCartDetailRepository;
import com.doan.student.service.OrderCartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCartDetailServiceImpl implements OrderCartDetailService
{
    @Autowired
    private OrderCartDetailRepository repository;
    @Autowired
    private OrderCartDetailConverter converter;
    @Override
    public String saveOrderCartDetail(OrderCartDetailDTO dto) {
       if(repository.findAll().isEmpty()){
           dto.setCode("OCD-00001");
       }
       else{
           String code= Constant.convertCode(repository.findFirstByOrderByIdDesc().getCode(), "OCD-");
           dto.setCode(code);
       }
       try{
           repository.save(converter.DtoToEntity(dto));
           return Constant.YES;
       }
       catch (Exception e){
           return Constant.NO;
       }



    }

    @Override
    public String existsByCode(String code) {
        return repository.existsByCode(code)?"true": "false";
    }

}
