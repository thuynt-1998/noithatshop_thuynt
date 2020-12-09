package com.doan.student.payload.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class RoomDTO {
    private Long id;
    @NotBlank
    private String code;
    @NotBlank
    private  String name;
    private String image;
    @NotBlank
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
