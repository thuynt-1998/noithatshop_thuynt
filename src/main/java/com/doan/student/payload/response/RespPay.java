package com.doan.student.payload.response;



public class RespPay {

    public  String titleService;
    public Long amount;
    public String titleShop;
    public String numDay;
    public String message;


    public String getMessage() {
        return message;
    }

    public Long getAmount() {
        return amount;
    }

    public String getNumDay() {
        return numDay;
    }

    public String getTitleService() {
        return titleService;
    }

    public String getTitleShop() {
        return titleShop;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setNumDay(String numDay) {
        this.numDay = numDay;
    }

    public void setTitleService(String titleService) {
        this.titleService = titleService;
    }

    public void setTitleShop(String titleShop) {
        this.titleShop = titleShop;
    }
}
