package com.acme.lunch.domain;

public class OrderNotFountException extends RuntimeException {

    private String orderId;
    public OrderNotFountException(String orderId) {
        super(String.format("Order(id=%s) not found", orderId));
        this.orderId = orderId;
    }
}
