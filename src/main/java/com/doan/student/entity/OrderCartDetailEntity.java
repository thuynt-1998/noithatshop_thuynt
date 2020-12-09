package com.doan.student.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "order_cart_detail" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
public class OrderCartDetailEntity {
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
    @JoinColumn(name = "order_cart")
    private OrderCartEntity orderCart;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public OrderCartEntity getOrderCart() {
        return orderCart;
    }

    public void setOrderCart(OrderCartEntity orderCart) {
        this.orderCart = orderCart;
    }
    @PrePersist
    public void seetInit(){
        setStatus("order");
    }
}
