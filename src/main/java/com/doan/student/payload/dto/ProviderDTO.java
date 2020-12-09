package com.doan.student.payload.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ProviderDTO {
    private  Long id;
    @NotBlank(message = "code không được để trống")
    private String code;
    @NotBlank(message = "tên nhà cung cấp không được rỗng")
    private  String name;
    @NotBlank(message = "số điện thoại không được rỗng")
    private String phone;
    @NotBlank
    private String address;
    @Email
    @NotBlank(message = "email không được rỗng")
    private  String email;
    @NotBlank(message = "status không được để trống")
    private  String status;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
