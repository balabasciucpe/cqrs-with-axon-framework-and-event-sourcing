package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.commands;

public class ProductCreatedCommand extends BaseCommand<String> {

    private Double productPrice;
    private Integer productNumber;
    private String productDescription;

    public ProductCreatedCommand(String id, Double productPrice, Integer productNumber, String productDescription) {
        super(id);
        this.productPrice = productPrice;
        this.productNumber = productNumber;
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
