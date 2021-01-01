package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.converter.ProductDetailConverter;
import com.doan.student.entity.ProductDetailEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import com.doan.student.repository.ProductDetailRepository;
import com.doan.student.repository.ProductRepository;
import com.doan.student.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailConverter productDetailConverter;
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetailDTO saveProductDetail(ProductDetailDTO dto) {


        if (productDetailRepository.existsByColors(dto.getColors())) {
            return productDetailConverter.EntityToDtoResponse(productDetailRepository.findByColors(dto.getColors()));
        } else {
            if (productDetailRepository.findAll().isEmpty()) {
                dto.setCode("PDT-00001");
            } else {
                String code = Constant.convertCode(productDetailRepository.findFirstByOrderByIdDesc().getCode(),
                        "PDT-");
                dto.setCode(code);
            }
        }
        return productDetailConverter.EntityToDtoResponse(productDetailRepository.save(productDetailConverter.DtoToEntity(dto)));

    }
    @Override
    public String existsByColors(String colors) {
        return productDetailRepository.existsByColors(colors) ? Constant.EXISTS :Constant.NO;
    }

    @Override
    public List<ProductDetailDTO> getProductDetailByProductId(Long id) {
        List<ProductDetailDTO> list = new ArrayList<>();
        List<ProductDetailEntity> entities = productDetailRepository.findByProductId(id);
        for (ProductDetailEntity entity : entities){
            list.add(productDetailConverter.EntityToDtoResponse(entity));
        }
        return list;
    }

    @Override
    public String updateStatus(Long id, String status) {
        try{
            productDetailRepository.updateRoomStatus(id, status);
            return Constant.YES;
        }
        catch (Exception e){
            return  Constant.NO;
        }

    }

    @Override
    public ProductDetailDTO getOne(String color) {
        return productDetailConverter.EntityToDtoResponse(productDetailRepository.findByColors(color));
    }

    @Override
    public String updateNumberStock(Long id, BigInteger number) {
        try{ productDetailRepository.updateNumberStock(id, number);
        return  Constant.YES;}
        catch (Exception e){
            return  Constant.NO;
        }

    }
}
