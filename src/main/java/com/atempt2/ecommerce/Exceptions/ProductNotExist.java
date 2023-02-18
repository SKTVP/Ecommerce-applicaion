package com.atempt2.ecommerce.Exceptions;

public class ProductNotExist extends  IllegalArgumentException{
    public  ProductNotExist(String msg){
        super(msg);
        }
}
