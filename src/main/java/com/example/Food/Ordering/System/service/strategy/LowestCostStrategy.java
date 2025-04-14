package com.example.foodordering.service.strategy;

import com.example.foodordering.model.Restaurant;
import com.example.foodordering.model.MenuItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LowestCostStrategy implements SelectionStrategy {

    @Override
    public Restaurant selectRestaurant(List<Restaurant> candidates, Map<String, Integer> items) {
        Restaurant best = null;
        int minCost = Integer.MAX_VALUE;

        for (Restaurant r : candidates) {
            int cost = items.entrySet().stream()
                    .mapToInt(e -> r.getMenu().get(e.getKey()).getPrice() * e.getValue())
                    .sum();
            if (cost < minCost) {
                minCost = cost;
                best = r;
            }
        }
        return best;
    }
}
