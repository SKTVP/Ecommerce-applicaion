package com.atempt2.ecommerce.repository;

import com.atempt2.ecommerce.model.AuthToken;
import com.atempt2.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tokenRepository extends JpaRepository<AuthToken,Long> {
    AuthToken findByUser(User user);

    AuthToken findByToken(String token);
}
