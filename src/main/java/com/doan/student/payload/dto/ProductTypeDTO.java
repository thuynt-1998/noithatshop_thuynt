package com.doan.student.payload.dto;

import com.doan.student.entity.ProductTypeEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ProductTypeDTO {
   private Long id;
   private  List<Long> idRooms;
   @NotBlank
   private String code;
   @NotBlank
   private  String name;
   private  String image;
   private List<RoomDTO> rooms;
   private List<ProductDTO> product;
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

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    public List<Long> getIdRooms() {
        return idRooms;
    }

    public void setIdRooms(List<Long> idRooms) {
        this.idRooms = idRooms;
    }

    public List<ProductDTO> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDTO> product) {
        this.product = product;
    }
}
