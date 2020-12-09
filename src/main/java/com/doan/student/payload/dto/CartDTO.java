package com.doan.student.payload.dto;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.ProductDetailEntity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CartDTO {
    private Long id;
    private String code;
    private BigInteger number;
    private BigDecimal price;
    private String status;
    private ProductDetailDTO productDetail;
    private CustomerDTO customer;

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

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductDetailDTO getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailDTO productDetail) {
        this.productDetail = productDetail;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
