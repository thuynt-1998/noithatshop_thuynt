package com.doan.student.payload.request;

import javax.validation.constraints.NotBlank;

public class SignUpAdminRequest {
    private Long id;
    @NotBlank(message = "username không được để trống")
    private String username ;
    @NotBlank(message = "password không được để trống")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
