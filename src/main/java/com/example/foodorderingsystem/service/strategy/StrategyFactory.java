package com.example.foodordering.service.strategy;

import com.example.foodordering.model.enums.StrategyType;
import com.example.foodordering.model.Restaurant;

public class StrategyFactory {

    public SelectionStrategy getStrategy(StrategyType strategyType) {
        switch (strategyType) {
            case LOWEST_COST:
                return new LowestCostStrategy();  
            case HIGHEST_RATING:
                return new HighestRatingStrategy(); 
            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }
    }
}
