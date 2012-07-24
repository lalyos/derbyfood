package com.acme.lunch;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.acme.lunch.domain.Address;
import com.acme.lunch.domain.Food;
import com.acme.lunch.domain.Order;
import com.acme.lunch.domain.OrderBuilder;
import com.acme.lunch.domain.OrderState;
import com.acme.lunch.domain.Restaurant;
import com.acme.lunch.service.jpa.JpaBasedOrderService;
import com.acme.lunch.service.jpa.JpaBasedRestaurantRepository;


public class App {

    private EntityManager manager;
    JpaBasedRestaurantRepository restaurantRepository;
    JpaBasedOrderService orderService;
    
    public App() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
        manager = factory.createEntityManager();
        restaurantRepository = new JpaBasedRestaurantRepository(manager);
        orderService = new JpaBasedOrderService(manager);
        
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        App app = new App();
        app.setUp();
        app.testQueries();
        app.orderFood();
    }
    
    private void setUp() {
        if (restaurantRepository.getAllRestaurants().size() < 1) {
            createRest1();
            createRest2();
        }
        
    }
    private void testQueries() {
        restaurantRepository.listAllMenu();
        List<Long> foodIds = Arrays.asList(3L, 11L);
        for (Long nextId : foodIds) {
            Food foodById = restaurantRepository.findFoodById(nextId);
            System.out.println(String.format("%nFood foundById(%d) : %s", nextId, foodById));            
        }
        
    }
    
    private void orderFood() {
        Address deliveryAddress = new Address("Otthonra", "bp", "hun", "1111");
        Order order = OrderBuilder.create(restaurantRepository).by("lalyos")
                .to(deliveryAddress)
                .withId(8L)
                .withId(9L, 3)
                .withId(4L, 2)
                .build();
        
        
        OrderState orderState = orderService.doOrder(order);
        System.out.println("order state: " + orderState);
    }
    
    private void createRest1() {
        manager.getTransaction().begin();

        Address address = new Address("Futo utca 42", "Budapest", "Hungary", "1082");
        
        Food food1 = new Food("pacal", 500, 800);
        Food food2 = new Food("palacsinta", 250, 200);
        Food food3 = new Food("babgulyas", 650, 1200);
        
        Restaurant restaurant = new Restaurant("Ancsa", address);
        restaurant.getMenu().add(food1);
        restaurant.getMenu().add(food2);
        restaurant.getMenu().add(food3);

        restaurantRepository.addRestaurant(restaurant);

        manager.getTransaction().commit();

    }

    private void createRest2() {
        manager.getTransaction().begin();

        Address address = new Address("Erzsébet körút 43-49", "Budapest", "Hungary", "1073");
        
        Food food1 = new Food("Okorppfa", 1100, 3400);
        Food food2 = new Food("Ludlab", 320, 1100);
        Food food3 = new Food("Libamajas Rizotto", 1220, 4400);
        Food food4 = new Food("Kemences Barany", 1520, 5700);
        
        Restaurant restaurant = new Restaurant("Bock Bistro", address);
        restaurant.setAddress(address);
        restaurant.getMenu().add(food1);
        restaurant.getMenu().add(food2);
        restaurant.getMenu().add(food3);
        restaurant.getMenu().add(food4);

        restaurantRepository.addRestaurant(restaurant);

        manager.getTransaction().commit();
    }

}
