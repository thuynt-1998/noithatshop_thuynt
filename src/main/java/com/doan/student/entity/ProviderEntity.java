package com.doan.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "provider", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class ProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private  String code;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
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
    @OneToMany(mappedBy = "provider")
    private final List<BillProviderEntity> billProvider= new ArrayList<>();

//

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<BillProviderEntity> getBillProvider() {
        return billProvider;
    }

}
