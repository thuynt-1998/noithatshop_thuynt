package com.doan.student.controller;

import com.doan.student.common.Constant;
import com.doan.student.payload.dto.ImageDTO;
import com.doan.student.payload.dto.ProductDTO;
import com.doan.student.payload.dto.ProductDetailDTO;
import com.doan.student.service.ImageServices;
import com.doan.student.service.ProductDetailService;
import com.doan.student.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private ImageServices imageServices;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/admin/save/product")
    @Transactional
    public ResponseEntity<Object> create(@Valid @RequestBody ProductDTO dto){
            try {


                ProductDTO productDTO = new ProductDTO();
                dto.setName(dto.getName().trim());
                productDTO = productServices.saveProduct(dto);

                if (!dto.getProductDetail().isEmpty()) {

                    for (ProductDetailDTO productDetailDTO : dto.getProductDetail()) {
                        ProductDetailDTO detail = new ProductDetailDTO();

                        productDetailDTO.setProduct(productDTO);
                        detail = productDetailService.saveProductDetail(productDetailDTO);

                        if (!productDetailDTO.getImages().isEmpty()) {

                            for (ImageDTO imageDTO : productDetailDTO.getImages()) {
                                imageDTO.setProductDetail(detail);
                                imageServices.save(imageDTO);
                                productServices.updataStatus(productDTO.getId(), Constant.ACTIVE);
                                productDetailService.updateStatus(productDetailDTO.getId(), Constant.ACTIVE);
                            }
                        }
                    }
                }
                return new ResponseEntity<Object>(Constant.YES, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<Object>(Constant.NO, HttpStatus.BAD_REQUEST);
            }

    }
    @GetMapping("/admin/getnew/product")
    public ResponseEntity<Object> getProductNew(){
        return new ResponseEntity<Object>(productServices.getAllProductNew(), HttpStatus.OK);
    }
    @GetMapping("/getbytype/product/{id}")
    public ResponseEntity<Object> getProductByTypeId( @PathVariable ("id") Long id){
        return new ResponseEntity<Object>(productServices.getProductByType(id), HttpStatus.OK);
    }
}
