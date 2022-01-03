package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.model;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.aggregate.OrderStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_orders")
public class Order {

    @Id
    private String orderId;
    private Double price;
    private Integer number;

    private String orderStatus;
    private String productId;

    public Order() {
    }

    public Order(String orderId, Double price, Integer number) {
        this.orderId = orderId;
        this.price = price;
        this.number = number;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
