package com.atempt2.ecommerce.model;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class AuthToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String token;
    @Column(name = "create_date")
    private Date createddate;

    //Join User to token. one to one relationship
    @OneToOne(targetEntity = User.class,fetch =FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    //getters and setters
    public String getToken() {
        return token;
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

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public AuthToken(User user) {
        this.user = user;
        this.createddate=new Date();
        this.token= UUID.randomUUID().toString();
    }

    public AuthToken() {
    }
}
