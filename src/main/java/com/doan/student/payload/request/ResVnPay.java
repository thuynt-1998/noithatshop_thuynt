package com.doan.student.payload.request;




public class ResVnPay {
    private String amount;
    private  String orderType;
    private  String orderInfo;
    private  String bankCode;
    private  String language;
    private  String ipAddress;

    public String getAmount() {
        return amount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getLanguage() {
        return language;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
