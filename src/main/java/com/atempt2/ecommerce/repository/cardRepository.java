package com.atempt2.ecommerce.repository;

import com.atempt2.ecommerce.model.User;
import com.atempt2.ecommerce.model.card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface cardRepository extends JpaRepository<card,Long> {


    List<card> findAllByUserOrderByDateDesc(User user);
}
