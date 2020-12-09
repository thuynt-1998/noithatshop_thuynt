package com.doan.student.controller;

import com.doan.student.converter.ProductDetailConverter;
import com.doan.student.entity.ImageEntity;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import com.doan.student.service.ImageServices;
import com.doan.student.service.ProductDetailService;
import com.doan.student.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductDetailConverter productDetailConverter;
    @Autowired
    private ImageServices imageServices;
    @PostMapping("/admin/save/product-detail")
    public ResponseEntity<Object> create(@Valid @RequestBody ProductDetailDTO productDetailDTO){
        ProductDTO dto= productServices.saveProduct(productDetailDTO.getProduct());
        ProductDetailDTO productDetailDTO1= productDetailService.saveProductDetail(productDetailDTO,dto );
        for (int i=0; i<productDetailDTO.getImages().size(); i++){
            ImageEntity entity = new ImageEntity();
            entity.setCode(productDetailDTO.getCode()+ (i+1));
            entity.setLink(productDetailDTO.getImages().get(i));
            entity.setProductDetail(productDetailConverter.DtoToEntityExistProduct(productDetailDTO1) );
            imageServices.save(entity);
        }
        return new ResponseEntity<Object>(productDetailDTO1, HttpStatus.OK);
    }
}
