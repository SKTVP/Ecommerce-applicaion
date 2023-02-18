package com.atempt2.ecommerce.repository;
import com.atempt2.ecommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product,Long> {
}
