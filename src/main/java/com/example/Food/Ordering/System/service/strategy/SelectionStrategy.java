package com.example.foodordering.service.strategy;

import com.example.foodordering.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface SelectionStrategy {
    Restaurant selectRestaurant(List<Restaurant> candidates, Map<String, Integer> items);
}
