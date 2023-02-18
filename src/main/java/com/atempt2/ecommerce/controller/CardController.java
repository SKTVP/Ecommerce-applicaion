package com.atempt2.ecommerce.controller;

import com.atempt2.ecommerce.common.ApiResponse;
import com.atempt2.ecommerce.dto.card.CardItemDto;
import com.atempt2.ecommerce.dto.card.addtoCardDTO;
import com.atempt2.ecommerce.dto.card.cardDTO;
import com.atempt2.ecommerce.model.User;
import com.atempt2.ecommerce.repository.cardRepository;
import com.atempt2.ecommerce.service.Authservice;
import com.atempt2.ecommerce.service.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
@Autowired
cardService cardserv;
@Autowired
Authservice authservice;
    @Autowired
    private cardRepository cardRepo;

    @PostMapping("/addCard")
    public ResponseEntity<ApiResponse> addTocart(@RequestBody addtoCardDTO addcarddto,
                                             @RequestParam("token") String token){
    authservice.authenticateToken(token);

    //find user
    User user=authservice.getUser(token);
    //save item in list


    cardserv.addtoCard(addcarddto,user);
    return new ResponseEntity<>(new ApiResponse(true,"added to card"), HttpStatus.CREATED);

}
@GetMapping("/cardList")
    public ResponseEntity<cardDTO> getCarditems(@RequestParam("token") String token){
    authservice.authenticateToken(token);

    //find user
    User user=authservice.getUser(token);
    //save item in list
    cardDTO cardto=cardserv.listCardItems(user);

    return new ResponseEntity<>(cardto,HttpStatus.OK);

}

    @PostMapping("/deletecard/{card_item}")
    public ResponseEntity<ApiResponse> deleteFromCart(@PathVariable Long card_item,
                                                 @RequestParam("token") String token) throws Exception {
        authservice.authenticateToken(token);

        //find user
        User user = authservice.getUser(token);



        //save item in list
         cardserv.delete(user,card_item);

        return new ResponseEntity<>( new ApiResponse(true,"Deleted"), HttpStatus.OK);
    }



    }
