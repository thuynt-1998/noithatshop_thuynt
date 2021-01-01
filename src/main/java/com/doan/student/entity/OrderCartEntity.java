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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_cart" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "code", name = "uniqueCode")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public class OrderCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String nameCustomer;
    @Column(name = "phone")
    private String phoneCustomer;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
    @Column(name = "note")
    private String note;
    @Column(name = "payments")
    private String payments;//phương thức thanh toán (paid, unpaid)
    @Column(name = "transport_free")
    private BigDecimal transportFree;//phí vận chuyển
    @Column(name="sum_bill")
    private  BigDecimal sumBill;//tổng hóa đơn
    @Column(name = "paid_customer")
    private BigDecimal paidCustomer;//số tiền khách đã trả
    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modifiedDate;
    @ManyToOne
    @JoinColumn(name = "by_customer")
    private CustomerEntity byCustomer;

//
    @JsonIgnore
    @OneToMany(mappedBy = "orderCart")
    private final List<OrderCartDetailEntity> orderCartDetail= new ArrayList<>();

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

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public BigDecimal getTransportFree() {
        return transportFree;
    }

    public void setTransportFree(BigDecimal transportFree) {
        this.transportFree = transportFree;
    }

    public BigDecimal getSumBill() {
        return sumBill;
    }

    public void setSumBill(BigDecimal sumBill) {
        this.sumBill = sumBill;
    }

    public BigDecimal getPaidCustomer() {
        return paidCustomer;
    }

    public void setPaidCustomer(BigDecimal paidCustomer) {
        this.paidCustomer = paidCustomer;
    }

    public CustomerEntity getByCustomer() {
        return byCustomer;
    }

    public void setByCustomer(CustomerEntity byCustomer) {
        this.byCustomer = byCustomer;
    }


    public List<OrderCartDetailEntity> getOrderCartDetail() {
        return orderCartDetail;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
