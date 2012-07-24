package com.acme.lunch.service;

import java.util.List;

import com.acme.lunch.domain.Food;
import com.acme.lunch.domain.Restaurant;

public interface RestaurantRepository {

	public List<Restaurant> getAllRestaurants();
	public Food findFoodById(Long id);
	public void listAllMenu();
	
}
