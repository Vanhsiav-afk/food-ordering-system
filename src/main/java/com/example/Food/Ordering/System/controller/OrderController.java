package com.example.foodordering.controller;

import com.example.foodordering.model.Order;
import com.example.foodordering.model.enums.StrategyType;
import com.example.foodordering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(
            @RequestParam String userName,
            @RequestBody Map<String, Integer> items,
            @RequestParam StrategyType strategyType) {
        return orderService.placeOrder(userName, items, strategyType);
    }

    @PostMapping("/{orderId}/complete")
    public String completeOrder(@PathVariable String orderId) {
        orderService.markOrderAsCompleted(orderId);
        return "Order marked as completed.";
    }
}
