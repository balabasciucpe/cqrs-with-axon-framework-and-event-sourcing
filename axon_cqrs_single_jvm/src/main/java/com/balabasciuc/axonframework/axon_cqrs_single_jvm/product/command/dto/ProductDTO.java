package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.dto;

public class ProductDTO {

    private String productId;
    private Double productPrice;
    private Integer productStock;
    private String productDescription;

    public ProductDTO() {
    }

    public ProductDTO(String productId, Double productPrice, Integer productStock, String productDescription) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
