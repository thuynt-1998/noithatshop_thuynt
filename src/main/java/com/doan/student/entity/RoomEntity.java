package com.doan.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false, unique = true, length = 30)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "decription")
    private String description;
    @Column (name = "image")
    private String image;
    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;
    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;
    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modifiedDate;
    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "modified_by", nullable = false)
    private UserEntity  modifiedBy;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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



}
