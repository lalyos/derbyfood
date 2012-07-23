package com.acme.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

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
    
    @OneToOne(mappedBy="address")
    private Restaurant restaurant;
    
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
        String resti = "" +  (restaurant == null ? "NULL" : restaurant.getId());
        return "Address [street=" + street + ", city=" + city + ", country="
                + country + ", zipcode=" + zipcode 
                + ", REST_ID=" + resti 
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    

}
