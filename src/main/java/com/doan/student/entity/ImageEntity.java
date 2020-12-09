package com.doan.student.entity;

import javax.persistence.*;

@Entity
@Table(name = "image" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name = "code")
    private String code;
     @Column(name = "link")
    private  String link;
     @Column(name = "status")
    private  String status;
    @ManyToOne
    @JoinColumn(name = "product_detail")
    private ProductDetailEntity productDetail;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
}
