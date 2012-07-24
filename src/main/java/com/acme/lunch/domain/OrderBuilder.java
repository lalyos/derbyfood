package com.acme.lunch.domain;

import java.util.logging.Logger;

import com.acme.lunch.service.RestaurantRepository;


public class OrderBuilder {

    private Order order = new Order();
    private RestaurantRepository repo;

    private OrderBuilder(RestaurantRepository repo) {
        this.repo = repo;
    }

    public OrderBuilder with(Food food) {
        order.addItem(new OrderItem(food));
        return this;
    }

    public OrderBuilder withId(Long foodId) {
        //logger.trace("searching for food={}", foodId);
        Food food = repo.findFoodById(foodId);
        order.addItem(new OrderItem(food));
        return this;
    }

    public OrderBuilder with(Food food, Integer quantity) {
        order.addItem(new OrderItem(food, quantity));
        return this;
    }

    public OrderBuilder withId(Long foodId, Integer quantity) {
        Food food = repo.findFoodById(foodId);
        order.addItem(new OrderItem(food, quantity));
        return this;
    }

    public OrderBuilder by(String customer) {
        order.setCustomer(customer);
        return this;
    }

    public OrderBuilder to(Address deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
        return this;
    }

    public Order build() {
        return order;
    }

    public static OrderBuilder create(RestaurantRepository repo) {
        // TODO Auto-generated method stub
        return new OrderBuilder(repo);
    }
}
