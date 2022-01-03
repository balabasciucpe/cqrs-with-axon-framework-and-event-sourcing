package com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.repository;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.order.query.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {


}
