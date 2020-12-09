package com.doan.student.service.impl;

import com.doan.student.converter.BillProviderConverter;
import com.doan.student.entity.BillProviderEntity;
import com.doan.student.payload.dto.BillProviderDTO;
import com.doan.student.payload.response.PageGetData;
import com.doan.student.repository.BillProviderRepository;
import com.doan.student.service.BillProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillProviderServiceImpl implements BillProviderService {
    @Autowired
    private BillProviderRepository billProviderRepository;
    @Autowired
    private BillProviderConverter billProviderConverter;
    @Override
    public BillProviderDTO saveBillProvider(BillProviderDTO billProviderDTO) {
        return existsByCode(billProviderDTO.getCode())=="false"? billProviderConverter.EntityToDto(billProviderRepository.save(billProviderConverter.DtoToEntity(billProviderDTO)))
                :billProviderConverter.EntityToDto(billProviderRepository.findByCode(billProviderDTO.getCode()));
    }

    @Override
    public String existsByCode(String code) {
        return billProviderRepository.existsByCode(code)?"true":"false";
    }

    @Override
    public PageGetData findByProviderId(Long id, Pageable pageable) {
        Page<BillProviderEntity> pages  = billProviderRepository.findByProviderId(id, pageable);
        List<BillProviderDTO> list= new ArrayList<>();
        for (BillProviderEntity entity: pages.getContent()){
            list.add( billProviderConverter.EntityToDto(entity));
        }
        PageGetData pageGetData = new PageGetData();
        pageGetData.setListDTO(list);
        pageGetData.setTotalPage(pages.getTotalPages());
        pageGetData.setTotalSize(pages.getSize());
        pageGetData.setTotalRecord(pages.getTotalElements());
        return pageGetData;
    }

    @Override
    public PageGetData findAll(Pageable pageable) {
        Page<BillProviderEntity> pages  = billProviderRepository.findAll( pageable);
        List<BillProviderDTO> list= new ArrayList<>();
        for (BillProviderEntity entity: pages.getContent()){
            list.add( billProviderConverter.EntityToDto(entity));
        }
        PageGetData pageGetData = new PageGetData();
        pageGetData.setListDTO(list);
        pageGetData.setTotalPage(pages.getTotalPages());
        pageGetData.setTotalSize(pages.getSize());
        pageGetData.setTotalRecord(pages.getTotalElements());
        return pageGetData;
    }

    @Override
    public PageGetData findByStatus(String status, Pageable pageable) {
        Page<BillProviderEntity> pages  = billProviderRepository.findByStatus(status, pageable);
        List<BillProviderDTO> list= new ArrayList<>();
        for (BillProviderEntity entity: pages.getContent()){
            list.add( billProviderConverter.EntityToDto(entity));
        }
        PageGetData pageGetData = new PageGetData();
        pageGetData.setListDTO(list);
        pageGetData.setTotalPage(pages.getTotalPages());
        pageGetData.setTotalSize(pages.getSize());
        pageGetData.setTotalRecord(pages.getTotalElements());
        return pageGetData;
    }
}
