package com.atempt2.ecommerce.service;

import com.atempt2.ecommerce.dto.card.CardItemDto;
import com.atempt2.ecommerce.dto.card.addtoCardDTO;
import com.atempt2.ecommerce.dto.card.cardDTO;
import com.atempt2.ecommerce.model.Product;
import com.atempt2.ecommerce.model.User;
import com.atempt2.ecommerce.model.card;
import com.atempt2.ecommerce.repository.cardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class cardService {
    @Autowired
    cardRepository cardrepo;
    @Autowired
    productService productserv;
    public void addtoCard(addtoCardDTO addcarddto, User user) {
        Product product=productserv.findById(addcarddto.getProuct_id());
        card card1 =new card();
        card1.setUser(user);
        card1.setProduct(product);
        card1.setQuantity(addcarddto.getQuantity());
        card1.setDate((new Date()));
                cardrepo.save(card1);
  }

    public cardDTO listCardItems(User user) {
       List<card> list1=cardrepo.findAllByUserOrderByDateDesc(user);

       List<CardItemDto> cartitems =new ArrayList<>();
       double totalcost=0;
        for(card card1:list1){
           CardItemDto cardItemDto=new CardItemDto(card1);
            totalcost+=cardItemDto.getQuantity()*cardItemDto.getProduct().getPrice();
           cartitems.add(cardItemDto);
        }
        cardDTO carddto=new cardDTO();
        carddto.setTotalcost(totalcost);
        carddto.setCarditems(cartitems);

        return carddto;
    }

    public void delete(User user, Long cardItem) throws Exception {
        Optional<card> list1=cardrepo.findById(cardItem);
        if(list1.isEmpty()){
            throw new Exception("not valid id");
        }
        card cart=list1.get();
        if(cart.getUser()!=user){
            throw new Exception("Not correct user");
        }
       else cardrepo.delete(cart);
    }

//    public cardDTO delete( User user, Long cardItem) throws Exception {
//        List<card> list1 = cardrepo.findAllByUserOrderByDateDesc(user);
//        double totalcost = 0;
//
//        List<CardItemDto> cartitems = new ArrayList<>();
//        for (card card1 : list1) {
//            CardItemDto cardItemDto = new CardItemDto(card1);
//
//            if (cardItemDto.getId() != cardItem) {
//
//                totalcost += cardItemDto.getQuantity() * cardItemDto.getProduct().getPrice();
//                cartitems.add(cardItemDto);
//            } else cardrepo.delete(card1);
//        }
//
//
//        cardDTO carddto1 = new cardDTO();
//        carddto1.setCarditems(cartitems);
//        carddto1.setTotalcost(totalcost);
//        return carddto1;
//
//        }

    }

