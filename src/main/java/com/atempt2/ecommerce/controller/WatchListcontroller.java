package com.atempt2.ecommerce.controller;

import com.atempt2.ecommerce.common.ApiResponse;
import com.atempt2.ecommerce.dto.watchListDTO;
import com.atempt2.ecommerce.dto.productDTO;
import com.atempt2.ecommerce.model.Product;
import com.atempt2.ecommerce.model.User;

import com.atempt2.ecommerce.model.watchList;
import com.atempt2.ecommerce.service.Authservice;

import com.atempt2.ecommerce.service.watchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class WatchListcontroller {
@Autowired
watchListService watchListserv;
@Autowired
    Authservice authservice;

//save product

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTokalathi(@RequestBody Product product,@RequestParam("token") String token){
        //authenticate token
        authservice.authenticateToken(token);

        //find user
        User user=authservice.getUser(token);
        //save item in list
        watchList watchList1=new watchList(user,product);
        watchListserv.saveitem(watchList1);

    return  new ResponseEntity<>(new ApiResponse(true,"Your item has been added to The kalathi"), HttpStatus.CREATED);
    }
    //get all kalathi products for users
    @GetMapping("/{token}")
    public ResponseEntity<List<productDTO>> getKalathi(@PathVariable("token")String token){
        //authenticate tok

         authservice.authenticateToken(token);

    //find user
    User user=authservice.getUser(token);
        return new ResponseEntity<>(watchListserv.showWatchListforUser(user),HttpStatus.OK);

    }
}
