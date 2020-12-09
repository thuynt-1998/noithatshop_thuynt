package com.doan.student.service.impl;

import com.doan.student.converter.ProviderConverter;
import com.doan.student.entity.ProviderEntity;
import com.doan.student.payload.dto.ProviderDTO;
import com.doan.student.repository.ProviderRepository;
import com.doan.student.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ProviderConverter providerConverter;
    @Override
    public ProviderDTO saveProvider(ProviderDTO providerDTO) {
        return existsByCode(providerDTO.getCode())=="false"? providerConverter.EntityToDto(providerRepository.save(providerConverter.DtoToEntity(providerDTO))) :null;
    }

    @Override
    public String existsByCode(String code) {
        return providerRepository.existsByCode(code) ?"true" :"false";
    }

    @Override
    public List<ProviderDTO> getAll(Pageable pageable) {
       List<ProviderEntity> list= providerRepository.findByStatus("active", pageable).getContent();
       List<ProviderDTO> listDto= new ArrayList<>();
       for (ProviderEntity entity : list){
           listDto.add(providerConverter.EntityToDto(entity));
       }

        return listDto;
    }
}
