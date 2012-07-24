package com.acme.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Food {

    public Food() {
        super();
    }
    public Food(String name, Integer price, Integer calories) {
        super();
        this.name = name;
        this.price = price;
        this.calories = calories;
    }
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Restaurant restaurant;
    
    private String name;
    private Integer price;
    private Integer calories;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getCalories() {
        return calories;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    @Override
    public String toString() {
        return "Food [id=" + id + ", name=" + name + ", price=" + price + ", calories=" + calories + "]";
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
}
