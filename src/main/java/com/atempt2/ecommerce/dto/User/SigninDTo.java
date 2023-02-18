package com.atempt2.ecommerce.dto.User;

public class SigninDTo {
    private String email;
    private String password;

    public SigninDTo() {

    }

    public String getEmail() {
        return email;
    }

    public SigninDTo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
