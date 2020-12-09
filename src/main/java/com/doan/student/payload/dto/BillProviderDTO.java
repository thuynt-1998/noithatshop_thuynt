package com.doan.student.payload.dto;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BillProviderDTO {
    private Long id;
    @NotBlank
    private String code;
    private BigDecimal totalPrice;
    private BigInteger totalNumber;
//    @NotBlank
    private ProviderDTO providerDTO;
    private String status;

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigInteger getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(BigInteger totalNumber) {
        this.totalNumber = totalNumber;
    }

    public ProviderDTO getProviderDTO() {
        return providerDTO;
    }

    public void setProviderDTO(ProviderDTO providerDTO) {
        this.providerDTO = providerDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
