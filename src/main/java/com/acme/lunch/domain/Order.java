package com.acme.lunch.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FoodOrder")
@NamedQuery( 
        name="findAllOrdersByCustomer", 
        query="SELECT o FROM Order o WHERE o.customer like :customer" )
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    Address deliveryAddress;
    
    @OneToMany(mappedBy="order")
    List<OrderItem> items = new ArrayList<OrderItem>();
    
    private String customer;
    private OrderState state;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public OrderState getState() {
        return state;
    }
    public void setState(OrderState state) {
        this.state = state;
    }
    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }
    
}
