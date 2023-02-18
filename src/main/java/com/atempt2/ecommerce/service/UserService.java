package com.atempt2.ecommerce.service;

import com.atempt2.ecommerce.Exceptions.AUthenticationFailedException;
import com.atempt2.ecommerce.dto.User.ResponseSignInDTO;
import com.atempt2.ecommerce.dto.User.SigninDTo;
import com.atempt2.ecommerce.dto.productDTO;
import com.atempt2.ecommerce.repository.UserRepository;
import com.atempt2.ecommerce.repository.tokenRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.atempt2.ecommerce.Exceptions.CustomerException;
import com.atempt2.ecommerce.dto.User.ResponseDTO;
import com.atempt2.ecommerce.dto.User.SignUpDTO;
import com.atempt2.ecommerce.model.AuthToken;
import com.atempt2.ecommerce.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    tokenRepository tokenRepository1;
    @Autowired
    Authservice authservice;
    @Transactional
    public ResponseDTO signup(SignUpDTO signUpDTO) {

        //check if emal alreay exists
        if(Objects.nonNull(userRepo.findByEmail(signUpDTO.getEmail()))){
            throw new CustomerException("User exists already");
        }
        //enctyp passowrd.
        String encryptedPassword=signUpDTO.getPassword();
        try{encryptedPassword=hashPassword(signUpDTO.getPassword());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        //save user
        User user=new User();
        user.setEmail(signUpDTO.getEmail());
        user.setLastname(signUpDTO.getLastname());
        user.setPassword(encryptedPassword);
        user.setLastname(signUpDTO.getLastname());
        userRepo.save(user);
        //generate authtoken
        final AuthToken authtoken1= new AuthToken(user);
       authservice.saveConfirmationToken(authtoken1);
       //send the response
       return new ResponseDTO("SUCESS","SIGNEDUP");

    }

//    private String hashPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest md=MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//        byte[]digest=md.digest();
//        String hash= DatatypeConverter
//                .printHexBinary(digest).toUpperCase();
//        return hash;
//    }

    private String hashPassword(String password)throws NoSuchAlgorithmException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


    public ResponseSignInDTO signin(SigninDTo signinDTo) {

        User user=userRepo.findByEmail(signinDTo.getEmail());

        //check if there is email in the repo
        if(Objects.isNull(user)){
            throw new AUthenticationFailedException("username  not valid");
        }

        //has the password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(signinDTo.getPassword(), user.getPassword())){
            throw new AUthenticationFailedException("password not correct");
        }


//        try {
////            if(!user.getPassword().equals(hashPassword(signinDTo.getPassword()))){
////                throw new AUthenticationFailedException("password not correct");
////            }
////        } catch (NoSuchAlgorithmException e) {
////            e.printStackTrace();
////        }
        //if password match

        AuthToken token=authservice.getToken(user);
        if(Objects.isNull(token)){
            throw new AUthenticationFailedException("token is not present");
        }
        return new ResponseSignInDTO("sucess",token.getToken());




        // compare the pass in DB




        //retrive the token


    }


    public List<SigninDTo> getAllusers() {
        List<User> all=userRepo.findAll();
        ArrayList<SigninDTo>Userdtos=new ArrayList<>();
        for(User user:all){
            Userdtos.add(getUserDTO(user));
        }
        return Userdtos;
    }

    private SigninDTo getUserDTO(User user) {
        SigninDTo signinDTo=new SigninDTo();
        signinDTo.setEmail(user.getEmail());
        signinDTo.setPassword(user.getPassword());
        return signinDTo;
    }



    public void deletUser(String email) throws UserPrincipalNotFoundException {

        Optional<User> user= Optional.ofNullable(userRepo.findByEmail(email));
        if(Objects.isNull(user)){
            throw new CustomerException("User does not exist");
        }
        User user1=user.get();

        AuthToken token=tokenRepository1.findByUser(user1);
        tokenRepository1.delete(token);
        userRepo.delete(user1);

    }
}
