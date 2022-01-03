package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.command.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {


    private Double price;
    private Integer number;


}
