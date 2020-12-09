package com.doan.student.payload.response;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class AuthenticationResponse {
    private String token;
    private String username;
    private List<SimpleGrantedAuthority> roles;

    public AuthenticationResponse(String token, String username, List<SimpleGrantedAuthority> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }


    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public AuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SimpleGrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<SimpleGrantedAuthority> roles) {
        this.roles = roles;
    }
}
