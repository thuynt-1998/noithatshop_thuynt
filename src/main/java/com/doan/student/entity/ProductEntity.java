package com.doan.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "material")
    private  String material;

    @Column(name = "source")
    private String source;
    @Column(name = "guarantee")
    private int guarantee;
    @Column(name = "description")
    private String description;
    @Column(name = "size")
    private  String size;
    @Column(name = "status")
    private String status;
    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    @CreatedBy
    private UserEntity createdBy;
    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modifiedDate;
    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "modified_by", nullable = false)
    private UserEntity  modifiedBy;

//
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private final List<ProductDetailEntity> detail= new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "type")
    private ProductTypeEntity type;



//


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductTypeEntity getType() {
        return type;
    }

    public void setType(ProductTypeEntity type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public UserEntity getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserEntity modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<ProductDetailEntity> getDetail() {
        return detail;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
