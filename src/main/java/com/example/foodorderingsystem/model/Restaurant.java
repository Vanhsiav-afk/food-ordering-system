package com.example.foodordering.model;

import lombok.Data;
import java.util.*;

@Data
public class Restaurant {
    private String name;
    private double rating;
    private int maxNoOfOrders;
    private int currentOrders;
    private Map<String, MenuItem> menu = new HashMap<>();
}

