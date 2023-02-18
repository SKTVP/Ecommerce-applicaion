package com.atempt2.ecommerce.service;

import com.atempt2.ecommerce.Exceptions.AUthenticationFailedException;
import com.atempt2.ecommerce.model.AuthToken;
import com.atempt2.ecommerce.model.User;
import com.atempt2.ecommerce.repository.UserRepository;
import com.atempt2.ecommerce.repository.tokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class Authservice {
    @Autowired
    tokenRepository tokenrepository;
    @Autowired
    private UserRepository userRepo;


    public  void saveConfirmationToken(AuthToken authtoken) {
        tokenrepository.save(authtoken);
    }

    public AuthToken getToken(User user) {
        return tokenrepository.findByUser(user);
    }

    public User getUser(String token){
        AuthToken token1 =tokenrepository.findByToken(token);
        if(Objects.isNull(token1)){
            return null;
        }
        User user=token1.getUser();
        return user;
    }
    public void authenticateToken(String token){
        //nullcheck
        if(Objects.isNull(token)){
            throw new AUthenticationFailedException("Token not Present");
        }
        if (Objects.isNull(getUser(token))){
            throw new AUthenticationFailedException("Token not valid");
        }
    }
}
