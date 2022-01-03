package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_products")
public class Product {

    @Id
    private String productId;

    private Double productPrice;
    private Integer productStock;
    private String productDescription;

    public Product(String productId, Double productPrice, Integer productStock, String productDescription) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
    }

    public Product() {
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

    public void depreciateStock(Integer number) {
        if (this.productStock >= number) {
            this.productStock -= number;
        }
        else
        {
            System.out.println("We don't have that number in our stock for now, try again later!");
        }
    }
}
