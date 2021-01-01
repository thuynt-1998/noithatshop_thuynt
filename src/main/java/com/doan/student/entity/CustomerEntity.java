package com.doan.student.entity;

import com.doan.student.common.Constant;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode"),
        @UniqueConstraint(columnNames = "account", name = "uniqueCode")})
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private  String code;
    @Column(name = "name")
    private  String name;
    @Column(name = "address")
    private  String address;
    @Column(name = "account")
    private  String account;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "status")
    private String status;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity  userEntity;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @PrePersist
    public void setPrevStatus(){
        setStatus(Constant.ACTIVE);
    }
}
