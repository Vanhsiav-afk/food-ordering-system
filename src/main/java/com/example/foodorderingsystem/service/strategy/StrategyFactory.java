package com.example.foodordering.service.strategy;

import com.example.foodordering.model.enums.StrategyType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class StrategyFactory {

    private final Map<StrategyType, SelectionStrategy> strategyMap = new EnumMap<>(StrategyType.class);

    public StrategyFactory(LowestCostStrategy lowest, HighestRatingStrategy highest) {
        strategyMap.put(StrategyType.LOWEST_COST, lowest);
        strategyMap.put(StrategyType.HIGHEST_RATING, highest);
    }

    public SelectionStrategy getStrategy(StrategyType type) {
        return strategyMap.get(type);
    }
}
