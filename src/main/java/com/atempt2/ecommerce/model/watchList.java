package com.atempt2.ecommerce.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "watchList")
public class watchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public watchList(Long id, User user, Date date, Product product) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.product = product;
    }

    public watchList() {
    }

    public watchList(User user, Product product) {
        this.user = user;
        this.product = product;
        this.date=new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
