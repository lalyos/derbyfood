package com.acme.lunch.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="address")
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public Address() {
    }
    
    public Address(String street, String city, String country, String zipcode) {
        super();
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }
    private String street;
    private String city;
    private String country;
    private String zipcode;
    
    
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    @Override
    public String toString() {
        String restaurantStr = "";
        for (Restaurant next : getRestaurants()) {
            restaurantStr += next.getName() + ", " ;
        }
        
        return "Address [street=" + street + ", city=" + city + ", country="
                + country + ", zipcode=" + zipcode 
                + ", RESTS=" + restaurantStr 
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy="addess")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}
