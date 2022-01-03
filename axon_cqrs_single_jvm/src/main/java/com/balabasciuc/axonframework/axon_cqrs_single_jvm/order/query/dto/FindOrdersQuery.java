package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.dto;


import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class FindOrdersQuery {

    public List<Order> orderList;


}
