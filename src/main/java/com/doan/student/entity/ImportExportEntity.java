package com.doan.student.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "import_export" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
public class ImportExportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "time")
    private String time;
    @Column(name = "import_product")
    private BigInteger numberImport;
    @Column(name = "export_product")
    private BigInteger numberExport;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigInteger getNumberImport() {
        return numberImport;
    }

    public void setNumberImport(BigInteger numberImport) {
        this.numberImport = numberImport;
    }

    public BigInteger getNumberExport() {
        return numberExport;
    }

    public void setNumberExport(BigInteger numberExport) {
        this.numberExport = numberExport;
    }

    public ProductDetailEntity getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailEntity productDetail) {
        this.productDetail = productDetail;
    }
}
