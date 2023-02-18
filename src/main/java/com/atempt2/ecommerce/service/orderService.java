package com.atempt2.ecommerce.service;

import com.atempt2.ecommerce.dto.order.checkOutItemDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class orderService {

@Value("${base_url}")
private String baseurl;
@Value("${stripe_ecret_key}")
private String secretkey;

@Value("${stripe_publishable_key}")
private  String publickey;
    public Session createSession(List<checkOutItemDTO> checkitemdtolist) throws StripeException {
    Stripe.apiKey=secretkey;
    String SuccessUrl=baseurl+"payment-sucess";
    String FailedlUrl=(baseurl+"payment-failed");

    List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

    for (checkOutItemDTO checkoutitemdto: checkitemdtolist){
        lineItems.add(sessionCreateLineItem(checkoutitemdto));
    }
    SessionCreateParams params =
            SessionCreateParams.builder()
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(SuccessUrl)
                    .setCancelUrl(FailedlUrl).addAllLineItem(lineItems).build();

    Session session = Session.create(params);
    return session;
    }

    private SessionCreateParams.LineItem sessionCreateLineItem(checkOutItemDTO checkoutitemdto) {
    return   SessionCreateParams.LineItem.builder()
            .setPriceData(createPriceData(checkoutitemdto))
            .setQuantity(Long.parseLong(String.valueOf(checkoutitemdto.getQuantity()))).build();

    }

    private SessionCreateParams.LineItem.PriceData createPriceData(checkOutItemDTO checkoutitemdto) {
    return SessionCreateParams.LineItem.PriceData.builder()
            .setCurrency("eur")
            .setUnitAmount((long)checkoutitemdto.getPrice()*100)
            .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                    .setName(checkoutitemdto.getProductName())
                    .build()).build();
    }


}
