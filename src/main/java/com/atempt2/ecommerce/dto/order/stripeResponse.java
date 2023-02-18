package com.atempt2.ecommerce.dto.order;

public class stripeResponse {
    private String session_id;

    public stripeResponse(String id) {
        this.session_id=id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
