package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.command.events;

public class StockUpdatedEvent {

    private String productId;
    private Integer productStock;


    public StockUpdatedEvent(String productId, Integer productStock) {
        this.productId = productId;
        this.productStock = productStock;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getProductStock() {
        return productStock;
    }
}
