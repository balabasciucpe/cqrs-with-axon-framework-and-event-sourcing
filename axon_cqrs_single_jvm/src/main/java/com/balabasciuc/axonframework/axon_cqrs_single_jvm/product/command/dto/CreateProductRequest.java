package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto;

public class CreateProductRequest {

    private Double productPrice;
    private Integer productStock;
    private String productDescription;

    public CreateProductRequest(Double productPrice, Integer productStock, String productDescription) {
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
