package com.doan.student.service.impl;

import com.doan.student.converter.BillProviderDetailConverter;
import com.doan.student.entity.BillProviderDetailEntity;
import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.dto.BillProviderDetailDTO;
import com.doan.student.payload.response.PageGetData;
import com.doan.student.repository.BillProviderDetailRepositoty;
import com.doan.student.service.BillProviderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillProviderDetailServiceImpl implements BillProviderDetailService {
    @Autowired
    private BillProviderDetailRepositoty billProviderDetailRepositoty;
    @Autowired
    private BillProviderDetailConverter billProviderDetailConverter;
    @Override
    public BillProviderDetailDTO saveBillProviderDetail(BillProviderDetailDTO billProviderDetailDTO, BillProviderDTO billProviderDTO) {
        return billProviderDetailConverter.EntityToDto(billProviderDetailRepositoty.save(billProviderDetailConverter.DtoToEntity(billProviderDetailDTO, billProviderDTO)));
    }

    @Override
    public String existsByCode(String code) {
        return billProviderDetailRepositoty.existsByCode(code)? "true":"false";
    }

    @Override
    public PageGetData findByBillProviderId(Long id, Pageable pageable) {
        Page<BillProviderDetailEntity> pages= billProviderDetailRepositoty.findByBillProviderId(id, pageable);
        List<BillProviderDetailDTO> list = new ArrayList<>();
        for (BillProviderDetailEntity entity : pages.getContent()){
            list.add(billProviderDetailConverter.EntityToDto(entity));
        }
        PageGetData  data= new PageGetData();
        data.setListDTO(list);
        data.setTotalPage(pages.getTotalPages());
        data.setTotalRecord(pages.getTotalElements());
        data.setTotalSize(pages.getSize());
         return data;
    }
}
