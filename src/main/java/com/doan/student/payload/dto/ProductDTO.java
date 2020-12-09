package com.doan.student.payload.dto;

public class ProductDTO {
    private Long id;
    private String code;
    private  String name;
    private String material;
    private String source;
    private int guarantee;
    private String size ;
    private String description;
    private String status;

    private ProductTypeDTO productType;

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
