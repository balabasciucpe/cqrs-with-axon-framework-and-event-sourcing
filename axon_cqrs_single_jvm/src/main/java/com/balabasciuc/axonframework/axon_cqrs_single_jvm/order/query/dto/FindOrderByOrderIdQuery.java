package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindOrderByOrderIdQuery {

    private String orderId;


}
