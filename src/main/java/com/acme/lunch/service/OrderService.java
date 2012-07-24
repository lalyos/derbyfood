package com.acme.lunch.service;

import java.util.List;

import javax.persistence.criteria.Order;

import com.acme.lunch.domain.OrderState;

public interface OrderService {

    public String doOrder(Order order);

    public OrderState getState(Long orderId);

    public List<Order> getFullHistory();

    public List<Order> getCustomerHistory(String customer);

}