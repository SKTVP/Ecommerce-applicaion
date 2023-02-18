package com.atempt2.ecommerce.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String name;
    @Column(name = "lastName")
    private String lastname;
    @Column(name = "emial")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private AuthToken token;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private watchList watchListI;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<card> card;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
