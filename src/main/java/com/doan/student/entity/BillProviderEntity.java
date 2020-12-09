package com.doan.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill_provider" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class BillProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private  String code;
    @Column(name = "total_number")
    private BigInteger totalNumber;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "note")
    private String note;
    @Column(name ="status" )
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
    @ManyToOne
    @JoinColumn(name = "provider")
    private ProviderEntity provider;
    @JsonIgnore
    @OneToMany(mappedBy = "billProvider")
    private final List<BillProviderDetailEntity> detail= new ArrayList<>();


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

    public BigInteger getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(BigInteger totalNumber) {
        this.totalNumber = totalNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public ProviderEntity getProvider() {
        return provider;
    }

    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    public List<BillProviderDetailEntity> getDetail() {
        return detail;
    }
}
