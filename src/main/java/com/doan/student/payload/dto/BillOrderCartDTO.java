package com.doan.student.payload.dto;

import java.math.BigDecimal;
import java.util.Date;

public class BillOrderCartDTO {
    private Long id;
    private String code;
    private BigDecimal amount;
    private OrderCartDTO orderCart;

    private Date createDate;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderCartDTO getOrderCart() {
        return orderCart;
    }

    public void setOrderCart(OrderCartDTO orderCart) {
        this.orderCart = orderCart;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
