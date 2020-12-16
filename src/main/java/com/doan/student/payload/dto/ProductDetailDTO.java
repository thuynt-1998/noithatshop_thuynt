package com.doan.student.payload.dto;

import com.doan.student.entity.ImageEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class ProductDetailDTO {
    private Long id;
    private  String code;
    private String colors;
    private BigInteger numberStock;
    private BigDecimal productPrice;
    private BigDecimal realPrice;
    private String status;
    private ProductDTO product;

    private List<ImageDTO> images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public BigInteger getNumberStock() {
        return numberStock;
    }

    public void setNumberStock(BigInteger numberStock) {
        this.numberStock = numberStock;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }
}
