package com.example.foodordering.model;

import com.example.foodordering.model.enums.OrderStatus;
import com.example.foodordering.model.enums.StrategyType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Order {
    private String orderId;
    private String userName;
    private Map<String, Integer> items;
    private Restaurant assignedRestaurant;
    private int totalCost;
    private OrderStatus status;
    private StrategyType strategyType;
}
