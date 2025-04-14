package com.example.foodordering.service;

import com.example.foodordering.exception.InvalidInputException;
import com.example.foodordering.model.MenuItem;
import com.example.foodordering.model.Restaurant;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
public class RestaurantService {

    private final Map<String, Restaurant> restaurantMap = new HashMap<>();

    public void onboardRestaurant(Restaurant restaurant) {
        if (restaurant == null || restaurant.getName() == null || restaurant.getName().isEmpty()) {
            throw new InvalidInputException("Invalid restaurant details");
        }
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    public void addOrUpdateMenu(String restaurantName, MenuItem item, boolean isUpdate) {
        Restaurant restaurant = restaurantMap.get(restaurantName);
        if (restaurant == null) throw new InvalidInputException("Restaurant not found");

        if (isUpdate) {
            if (!restaurant.getMenu().containsKey(item.getName())) {
                throw new InvalidInputException("Cannot update non-existing menu item");
            }
        }

        restaurant.getMenu().put(item.getName(), item); // Add or update
    }
}
