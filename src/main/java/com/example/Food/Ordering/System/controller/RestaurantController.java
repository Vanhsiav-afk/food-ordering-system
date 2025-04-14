package com.example.foodordering.controller;

import com.example.foodordering.model.MenuItem;
import com.example.foodordering.model.Restaurant;
import com.example.foodordering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/onboard")
    public String onboardRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.onboardRestaurant(restaurant);
        return "Restaurant onboarded successfully!";
    }

    @PostMapping("/{name}/menu")
    public String addMenuItem(@PathVariable String name, @RequestBody MenuItem item) {
        restaurantService.addOrUpdateMenu(name, item, false);
        return "Menu item added!";
    }

    @PutMapping("/{name}/menu")
    public String updateMenuItem(@PathVariable String name, @RequestBody MenuItem item) {
        restaurantService.addOrUpdateMenu(name, item, true);
        return "Menu item updated!";
    }
}
