package com.doan.student.converter;

import com.doan.student.entity.ImageEntity;
import com.doan.student.entity.ProductDetailEntity;
import com.doan.student.entity.ProductEntity;
import com.doan.student.payload.dto.ImageDTO;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDetailConverter {

    @Autowired
    private  ProductConverter productConverter;
    @Autowired
    private ProductTypeConverter productTypeConverter;
    @Autowired
    private  ImageConverter imageConverter;

    public ProductDetailEntity DtoToEntity(ProductDetailDTO dto ){
        ProductDetailEntity entity=  new ProductDetailEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setColors(dto.getColors());
        entity.setProductPrice(dto.getProductPrice());
        entity.setRealPrice(dto.getRealPrice());
        entity.setNumberStock(dto.getNumberStock());
        entity.setStatus(dto.getStatus());
        entity.setProduct(productConverter.DtoToEntity(dto.getProduct()));
        return entity;

    }

    public ProductDetailDTO EntityToDtoResponse(ProductDetailEntity entity){
        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setColors(entity.getColors());
        dto.setNumberStock(entity.getNumberStock());
        dto.setProductPrice(entity.getProductPrice());
        dto.setRealPrice(entity.getRealPrice());
        List<ImageDTO> list = new ArrayList<>();
        for (ImageEntity entityImage: entity.getImage()){
            list.add(imageConverter.EntityToDto(entityImage));
        }
        dto.setImages(list);
        dto.setStatus(entity.getStatus());
        return dto;
    }
    public ProductDTO EntityToDtoCart(ProductDetailEntity entity){
        List<ProductDetailDTO> listDto=  new ArrayList<>();
        ProductDTO dto = productConverter.EntityToDto(entity.getProduct());
        ProductDetailDTO dtoDetail= EntityToDtoResponse(entity);
        listDto.add(dtoDetail);
        dto.setProductDetail(listDto);
        return dto;
    }

    public ProductDetailEntity DtoToEntityCart(ProductDTO dto){
        dto.getProductDetail().get(0).setProduct(dto);
        ProductDetailEntity entity = DtoToEntity(dto.getProductDetail().get(0));
        return entity;
    }




}
