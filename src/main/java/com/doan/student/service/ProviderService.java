package com.doan.student.service;

import com.doan.student.payload.dto.ProviderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface ProviderService {
    ProviderDTO saveProvider(ProviderDTO providerDTO);
    String existsByCode(String code);
    List<ProviderDTO> getAll(Pageable pageable);
}
