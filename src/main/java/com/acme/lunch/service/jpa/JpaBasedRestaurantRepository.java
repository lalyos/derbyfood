package com.acme.lunch.service.jpa;

import java.util.List;
import static java.lang.String.format;

import javax.persistence.EntityManager;

import com.acme.lunch.domain.Address;
import com.acme.lunch.domain.Food;
import com.acme.lunch.domain.Restaurant;
import com.acme.lunch.service.RestaurantRepository;

public class JpaBasedRestaurantRepository implements RestaurantRepository {

    private EntityManager em;
    public JpaBasedRestaurantRepository(EntityManager em) {
       this.em = em;
    }
    
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> resultList = em.createNamedQuery("findAllRestaurant").getResultList();
        return resultList;
    }

    public Food findFoodById(Long id) {
        Food food = em.find(Food.class, id);
        return food;
    }

    public void listAllMenu() {
        List<Restaurant> allRestaurants = getAllRestaurants();
        for (Restaurant restaurant : allRestaurants) {
            System.out.println(format("== %-20s " , restaurant.getName(), restaurant.getId()));
            for (Food food : restaurant.getMenu()) {
                System.out.println(format("\t[%3s] %-30s %4d Ft [%4d kCal]", food.getId(), food.getName(), food.getPrice() , food.getCalories()));
                
            }
        }

    }

    public void addRestaurant(Restaurant restaurant) {
        
        em.persist(restaurant);
        
        Address address = restaurant.getAddress();
        em.persist(address);
        List<Food> menu = restaurant.getMenu();
        for (Food food : menu) {
            //set relation and persist
            food.setRestaurant(restaurant);
            em.persist(food);
        }
        em.persist(restaurant);
        
    }
}
