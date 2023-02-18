package com.atempt2.ecommerce.controller;
import com.atempt2.ecommerce.common.ApiResponse;
import com.atempt2.ecommerce.dto.User.ResponseDTO;
import com.atempt2.ecommerce.dto.User.ResponseSignInDTO;
import com.atempt2.ecommerce.dto.User.SignUpDTO;
import com.atempt2.ecommerce.dto.User.SigninDTo;
import com.atempt2.ecommerce.dto.productDTO;
import com.atempt2.ecommerce.repository.UserRepository;
import com.atempt2.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;


@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseDTO signup(@RequestBody SignUpDTO signUpDTO){

        userService.signup(signUpDTO);
        return new ResponseDTO("sucess","User sign up");
    }
    @PostMapping("/signin")
    public ResponseSignInDTO signin(@RequestBody SigninDTo signinDTo){
        return userService.signin(signinDTo);
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<SigninDTo>> getUsers(){
        List<SigninDTo>SigninDTOs=userService.getAllusers();
        return new ResponseEntity<>(SigninDTOs, HttpStatus.OK);
    }
    @PostMapping("/deleteUser/{email}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable String email) throws UserPrincipalNotFoundException {
        userService.deletUser(email);
        return new ResponseEntity<>(new ApiResponse(true,"Your User has been deleted"),HttpStatus.OK);
    }

}



