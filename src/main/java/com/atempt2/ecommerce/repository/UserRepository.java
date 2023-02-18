package com.atempt2.ecommerce.repository;

import com.atempt2.ecommerce.dto.User.SigninDTo;
import com.atempt2.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);



}
