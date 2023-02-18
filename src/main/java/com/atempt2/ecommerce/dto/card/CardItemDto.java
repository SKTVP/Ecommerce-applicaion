package com.atempt2.ecommerce.dto.card;

import com.atempt2.ecommerce.model.Product;
import com.atempt2.ecommerce.model.card;
import jakarta.persistence.criteria.CriteriaBuilder;

public class CardItemDto {
    private Long id;
    private Product product;
    private Integer quantity;



    public CardItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CardItemDto(card card) {
        this.id = card.getId();
        this.quantity=card.getQuantity();
        this.setProduct(card.getProduct());

    }
}