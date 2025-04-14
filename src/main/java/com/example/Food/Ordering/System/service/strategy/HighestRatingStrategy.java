package com.example.foodordering.service.strategy;

import com.example.foodordering.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class HighestRatingStrategy implements SelectionStrategy {

    @Override
    public Restaurant selectRestaurant(List<Restaurant> candidates, Map<String, Integer> items) {
        return candidates.stream()
                .max(Comparator.comparing(Restaurant::getRating))
                .orElse(null);
    }
}
