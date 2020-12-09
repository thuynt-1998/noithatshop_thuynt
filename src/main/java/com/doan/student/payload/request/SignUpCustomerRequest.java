package com.doan.student.payload.request;

import javax.validation.constraints.NotBlank;

public class SignUpCustomerRequest {
    private Long id;
    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;
    @NotBlank(message = "Mật khẩu không để trống")
    private String password;
    @NotBlank(message = "mã code không để trống")
    private String code;
    @NotBlank(message = "tên tài khoản không để trống ")
    private String account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
