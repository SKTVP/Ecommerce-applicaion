package com.atempt2.ecommerce.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cards")
public class card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    //Join product
    @ManyToOne
    @JoinColumn(name="prouct_id")
    private Product product;
    //Join user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "quantity")
    private Integer quantity;


    //getters and setters
    public card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
