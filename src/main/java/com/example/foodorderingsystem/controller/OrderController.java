package com.example.foodordering.controller;

import com.example.foodordering.model.Order;
import com.example.foodordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/{orderId}/complete")
    public ResponseEntity<String> completeOrder(@PathVariable String orderId) {
        orderService.markOrderAsCompleted(orderId);
        return ResponseEntity.ok("Order marked as completed");
    }
}
