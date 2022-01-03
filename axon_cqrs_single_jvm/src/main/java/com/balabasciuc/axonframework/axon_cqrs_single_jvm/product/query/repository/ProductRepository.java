package com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.repository;

import com.balabasciuc.axonframework.axon_cqrs_single_jvm.product.query.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
