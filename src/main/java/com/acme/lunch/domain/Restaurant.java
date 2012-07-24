package com.acme.lunch.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery( 
        name="findAllRestaurant", 
        query="SELECT r FROM Restaurant r" )
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="restaurant")
    private List<Food> menu = new ArrayList<Food>();

    @ManyToOne
    private Address address;

    private String name;
    
    public Restaurant() {
        super();
    }

    public Restaurant(String name, Address address) {
        super();
        this.name = name;
        this.address = address;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }

}
