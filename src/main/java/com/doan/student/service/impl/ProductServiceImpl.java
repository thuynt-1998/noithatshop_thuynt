package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.converter.ProductConverter;
import com.doan.student.entity.ProductEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.repository.ProductRepository;
import com.doan.student.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;
    @Override
    public ProductDTO saveProduct(ProductDTO dto) {

           if(existsByName(dto.getName()).equals(Constant.EXISTS)){
               ProductEntity entity= productRepository.findByName(dto.getName());
               return productConverter.EntityToDto(entity);
           }
           else{
               if(productRepository.findAll().isEmpty())
               {
                   dto.setCode("PD-00001");
               }
               else{
                   String code= Constant.convertCode(productRepository.findFirstByOrderByIdDesc().getCode(), "PD-");
                   dto.setCode(code);
               }
               return productConverter.EntityToDto( productRepository.save(productConverter.DtoToEntity(dto)));
           }
    }

    @Override
    public String existsByName(String name) {
        return productRepository.existsByName(name) ?Constant.EXISTS :Constant.NO;
    }

    @Override
    public String existsByCode(String code) {
        return productRepository.existsByCode(code) ?Constant.EXISTS :Constant.NO;
    }

    @Override
    public List<ProductDTO> getAllProductNew() {
        List<ProductEntity> entities= productRepository.findTop10DistinctionByStatusOrderByCreatedDateDesc(Constant.ACTIVE);
        List<ProductDTO> list = new ArrayList<>();
        for (ProductEntity entity: entities){
            list.add(productConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public List<ProductDTO> getProductByType(Long id) {
        List<ProductEntity> entities= productRepository.findByTypeId(id);
        List<ProductDTO> list = new ArrayList<>();
        for (ProductEntity entity: entities){
            list.add(productConverter.EntityToDto(entity));
        }
        return list;
    }

    @Override
    public String updataStatus(Long id, String status) {
        try{
            productRepository.updateRoomStatus(id, status);
            return Constant.YES;
        }
        catch (Exception e){
            return  Constant.NO;
        }

    }

    @Override
    public String updateProduct(ProductDTO dto) {
        return null;
    }

    @Override
    public ProductDTO findByName(String name) {
         productRepository.findByName(name);
        ProductEntity entity = new ProductEntity();
        return productConverter.EntityToDto(entity);
    }
}
