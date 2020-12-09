package com.doan.student.payload.dto;

import com.doan.student.entity.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public class OrderCartDTO {
    private  Long id;
    private String code;
    private String nameCustomer;
    private String phoneCustomer;
    private String address;
    private String status;
    private String note;
    private String payments;
    private BigDecimal transportFree;
    private List<OrderCartDetailDTO> orderCartDetails;
    private List<CartDTO> carts;
    private CustomerDTO customer;

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

    public List<OrderCartDetailDTO> getOrderCartDetails() {
        return orderCartDetails;
    }

    public void setOrderCartDetails(List<OrderCartDetailDTO> orderCartDetails) {
        this.orderCartDetails = orderCartDetails;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<CartDTO> getCarts() {
        return carts;
    }

    public void setCarts(List<CartDTO> carts) {
        this.carts = carts;
    }
}
