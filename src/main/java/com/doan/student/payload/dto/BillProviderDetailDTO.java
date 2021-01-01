package com.doan.student.payload.dto;

import com.doan.student.payload.response.JwtAdminResponse;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BillProviderDetailDTO {
    private Long id;
    private String code;
    private BigInteger number;
    private BigDecimal price;
    private BillProviderDTO billProviderDTO;
    private ProductDetailDTO productDetail;
    private JwtAdminResponse jwt ;
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

    public BillProviderDTO getBillProviderDTO() {
        return billProviderDTO;
    }

    public void setBillProviderDTO(BillProviderDTO billProviderDTO) {
        this.billProviderDTO = billProviderDTO;
    }

    public ProductDetailDTO getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailDTO productDetail) {
        this.productDetail = productDetail;
    }

    public JwtAdminResponse getJwt() {
        return jwt;
    }

    public void setJwt(JwtAdminResponse jwt) {
        this.jwt = jwt;
    }
}
