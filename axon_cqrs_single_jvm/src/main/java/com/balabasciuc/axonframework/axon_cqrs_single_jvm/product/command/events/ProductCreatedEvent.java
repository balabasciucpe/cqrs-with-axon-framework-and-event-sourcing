package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.events;

public class ProductCreatedEvent extends BaseEvent<String> {

    private Double productPrice;
    private Integer productStock;
    private String productDescription;

    public ProductCreatedEvent(String id, Double productPrice, Integer productStock, String productDescription) {
        super(id);
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
