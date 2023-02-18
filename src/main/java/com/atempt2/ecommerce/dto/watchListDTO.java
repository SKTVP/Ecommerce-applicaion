package com.atempt2.ecommerce.dto;

import com.atempt2.ecommerce.model.Product;
import com.atempt2.ecommerce.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class watchListDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private @NotNull Long user_id;

    private @NotNull Date date;

    private @NotNull Long product_id;





    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
