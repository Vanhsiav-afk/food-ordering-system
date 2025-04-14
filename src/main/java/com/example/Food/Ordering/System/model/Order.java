package com.example.foodordering.model;

import com.example.foodordering.model.enums.OrderStatus;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class Order {
    private String orderId;
    private String userName;
    private Map<String, Integer> items; // itemName -> quantity
    private OrderStatus status;
    private Restaurant assignedRestaurant;
    private int totalCost;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.status = OrderStatus.ACCEPTED;
    }
}
