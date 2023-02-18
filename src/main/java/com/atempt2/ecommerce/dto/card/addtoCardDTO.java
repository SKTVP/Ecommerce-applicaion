package com.atempt2.ecommerce.dto.card;

import com.atempt2.ecommerce.model.Product;
import com.atempt2.ecommerce.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class addtoCardDTO {

    private Long id;
    private@NotNull  Long prouct_id;

    private @NotNull Integer quantity;

    public addtoCardDTO() {
    }

    public Long getProuct_id() {
        return prouct_id;
    }

    public void setProuct_id(Long prouct_id) {
        this.prouct_id = prouct_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
