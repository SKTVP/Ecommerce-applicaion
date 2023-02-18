package com.atempt2.ecommerce.common;
import java.time.LocalTime;

public class ApiResponse {
    private final boolean sucess;
    private final String Message;

    public ApiResponse(boolean sucess, String message) {
        this.sucess = sucess;
        Message = message;
    }
    public boolean isSucess() {
        return sucess;
    }

    public String getMessage() {
        return Message;
    }

    public String getTimestamp(){
        return LocalTime.now().toString();
    }
}
