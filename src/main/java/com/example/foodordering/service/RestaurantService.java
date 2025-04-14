package com.example.foodordering.service;

import com.example.foodordering.exception.InvalidInputException;
import com.example.foodordering.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantService {

    private final Map<String, Restaurant> restaurantMap = new HashMap<>();

    public Restaurant addRestaurant(Restaurant restaurant) {
        if (restaurantMap.containsKey(restaurant.getRestaurantId())) {
            throw new InvalidInputException("Restaurant with this ID already exists.");
        }
        restaurantMap.put(restaurant.getRestaurantId(), restaurant);
        return restaurant;
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantMap.values());
    }

    public Map<String, Restaurant> getRestaurantMap() {
        return restaurantMap;
    }
}
