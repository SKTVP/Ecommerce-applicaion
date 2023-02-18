package com.atempt2.ecommerce.controller;

import com.atempt2.ecommerce.dto.order.checkOutItemDTO;

import com.atempt2.ecommerce.dto.order.stripeResponse;

import com.atempt2.ecommerce.service.Authservice;
import com.atempt2.ecommerce.service.orderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Authservice authservice;

   @Autowired
   private orderService orderserv;
    //stripe session api
    @PostMapping("/create-chechout-payment")
        public ResponseEntity<stripeResponse> checkoutlist(@RequestBody List<checkOutItemDTO> checkitemdtolist) throws StripeException {
      Session session=orderserv.createSession(checkitemdtolist);
        stripeResponse striperesponse=new stripeResponse(session.getId());
      return new ResponseEntity<>(striperesponse, HttpStatus.OK);
    }

}
