package com.example.foodordering.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Restaurant {

    private String restaurantId;
    private String name;
    private Map<String, MenuItem> menu;
    private int currentOrders;
    private int maxNoOfOrders;
    private double rating;  

    public double getRating() {
        return this.rating;
    }

    public String getRestaurantId() {
        return this.restaurantId;
    }
}
