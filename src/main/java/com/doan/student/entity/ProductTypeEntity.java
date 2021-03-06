package com.doan.student.entity;

import com.doan.student.common.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false, unique = true, length = 30)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "decription")
    private String description;
    @Column (name = "image")
    private String image;
    @Column(name = "status", nullable = false)
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
    @OneToMany(mappedBy = "type")
    private final List<ProductEntity> product= new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "room_type", joinColumns = @JoinColumn(name = "product_type_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Set<RoomEntity> room =new HashSet<>();
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

    public List<ProductEntity> getProduct() {
        return product;
    }

    public Set<RoomEntity> getRoom() {
        return room;
    }

    public void setRoom(Set<RoomEntity> room) {
        this.room = room;
    }



    @PrePersist
    public void setPrevStatus(){
        setStatus(Constant.STOP);
    }

}
