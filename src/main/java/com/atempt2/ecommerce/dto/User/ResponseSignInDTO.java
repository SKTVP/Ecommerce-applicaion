package com.atempt2.ecommerce.dto.User;

public class ResponseSignInDTO {
    private  String status;

    public String getStatus() {
        return status;
    }

    public ResponseSignInDTO(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private  String  token;
}
