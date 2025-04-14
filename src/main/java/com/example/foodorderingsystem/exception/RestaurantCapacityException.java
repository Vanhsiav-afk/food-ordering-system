package com.example.foodordering.exception;

public class RestaurantCapacityException extends RuntimeException {
    public RestaurantCapacityException(String message) {
        super(message);
    }
}
