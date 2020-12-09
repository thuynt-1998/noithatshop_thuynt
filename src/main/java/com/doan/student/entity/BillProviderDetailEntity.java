package com.doan.student.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "bill_provider_detail" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})

public class BillProviderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private  String code;
    @Column(name = "number")
    private BigInteger number;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "product_detail")
    private ProductDetailEntity productDetail;
    @Column(name = "note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "bill")
    private BillProviderEntity billProvider;

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

    public ProductDetailEntity getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailEntity productDetail) {
        this.productDetail = productDetail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BillProviderEntity getBillProvider() {
        return billProvider;
    }

    public void setBillProvider(BillProviderEntity billProvider) {
        this.billProvider = billProvider;
    }
}
