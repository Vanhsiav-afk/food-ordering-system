package com.example.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
@AllArgsConstructor
public class MenuItem {
    private String name;
    private int price;
}