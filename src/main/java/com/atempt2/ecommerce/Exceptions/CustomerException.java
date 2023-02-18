package com.atempt2.ecommerce.Exceptions;

public class CustomerException extends IllegalArgumentException {
    public CustomerException(String msg){
        super(msg);
    }
}
