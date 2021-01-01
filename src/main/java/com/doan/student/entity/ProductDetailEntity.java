package com.doan.student.entity;

import com.doan.student.common.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_detail" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private  String code;
    @Column(name = "colors")
    private String colors;
    @Column(name = "number_stock")
    private BigInteger numberStock;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Column(name = "real_price")
    private  BigDecimal realPrice;

    @Column(name = "status")
    private String status;

//
    @ManyToOne
    @JoinColumn(name = "product")
    private ProductEntity product;
//

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private final List<ImageEntity> image= new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private final List<BillProviderDetailEntity> providerDetail= new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private final List<ImportExportEntity> importExport= new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private final List<OrderCartDetailEntity> orderCartDetailEntities= new ArrayList<>();


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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<ImageEntity> getImage() {
        return image;
    }

    public List<BillProviderDetailEntity> getProviderDetail() {
        return providerDetail;
    }

    public List<ImportExportEntity> getImportExport() {
        return importExport;
    }

    public List<OrderCartDetailEntity> getOrderCartDetailEntities() {
        return orderCartDetailEntities;
    }


    @PrePersist
    public void setPrevStatus(){
        setStatus(Constant.STOP);
    }
}
