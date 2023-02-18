package com.atempt2.ecommerce.dto.User;

public class ResponseDTO {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public ResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
