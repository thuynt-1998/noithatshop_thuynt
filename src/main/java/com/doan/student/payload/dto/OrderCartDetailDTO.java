package com.doan.student.payload.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderCartDetailDTO {
    private Long id;
    private String code;
    private BigInteger number;
    private BigDecimal price;
    private String status;
    private ProductDTO product;
    private OrderCartDTO orderCart;


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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public OrderCartDTO getOrderCart() {
        return orderCart;
    }

    public void setOrderCart(OrderCartDTO orderCart) {
        this.orderCart = orderCart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
