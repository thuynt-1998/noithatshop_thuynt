package com.doan.student.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "cart" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "number")
    private BigInteger number;
    @Column(name = "product_price")
    private BigDecimal price;
    @Column(name= "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "product_detail")
    private ProductDetailEntity productDetail;

    @ManyToOne
    @JoinColumn(name = "customer")
    private CustomerEntity customer;

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

    public ProductDetailEntity getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailEntity productDetail) {
        this.productDetail = productDetail;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

}
