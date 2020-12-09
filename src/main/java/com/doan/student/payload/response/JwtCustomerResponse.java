package com.doan.student.payload.response;

import com.doan.student.payload.dto.CustomerDTO;

import java.util.List;

public class JwtCustomerResponse {
    private final String jwtToken;
    private CustomerDTO customerDTO;
    private List<String> roles;

    public JwtCustomerResponse(String jwtToken, CustomerDTO customerDTO, List<String> roles) {
        this.jwtToken = jwtToken;
        this.customerDTO = customerDTO;
        this.roles = roles;
    }

    public JwtCustomerResponse(String jwtToken, CustomerDTO customerDTO) {
        this.jwtToken = jwtToken;
        this.customerDTO = customerDTO;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
