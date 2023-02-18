package com.atempt2.ecommerce.repository;

import com.atempt2.ecommerce.model.Category;


import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<Category, Long> {

}
