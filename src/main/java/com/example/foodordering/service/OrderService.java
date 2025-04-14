package com.example.foodordering.service;

import com.example.foodordering.exception.InvalidInputException;
import com.example.foodordering.model.Order;
import com.example.foodordering.model.Restaurant;
import com.example.foodordering.model.enums.OrderStatus;
import com.example.foodordering.model.enums.StrategyType;
import com.example.foodordering.service.strategy.SelectionStrategy;
import com.example.foodordering.service.strategy.StrategyFactory;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Getter
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final RestaurantService restaurantService;
    private final StrategyFactory strategyFactory;

    public OrderService(RestaurantService restaurantService, StrategyFactory strategyFactory) {
        this.restaurantService = restaurantService;
        this.strategyFactory = strategyFactory;
    }

    public Order placeOrder(String userName, Map<String, Integer> items, StrategyType strategyType) {
        SelectionStrategy strategy = strategyFactory.getStrategy(strategyType);
        List<Restaurant> candidates = new ArrayList<>();

        for (Restaurant restaurant : restaurantService.getRestaurantMap().values()) {
            if (restaurant.getCurrentOrders() >= restaurant.getMaxNoOfOrders()) continue;

            if (restaurant.getMenu().keySet().containsAll(items.keySet())) {
                candidates.add(restaurant);
            }
        }

        if (candidates.isEmpty()) {
            throw new InvalidInputException("Cannot assign the order. No suitable restaurant found.");
        }

        Restaurant selectedRestaurant = strategy.selectRestaurant(candidates, items);

        if (selectedRestaurant == null) {
            throw new InvalidInputException("No restaurant matched the strategy");
        }

        selectedRestaurant.setCurrentOrders(selectedRestaurant.getCurrentOrders() + 1);

        Order order = new Order();
        order.setUserName(userName);
        order.setItems(items);
        order.setAssignedRestaurant(selectedRestaurant);
        order.setTotalCost(calculateTotal(selectedRestaurant, items));
        order.setStrategyType(strategyType);
        order.setStatus(OrderStatus.PENDING);

        orders.add(order);
        return order;
    }

    public Order placeOrder(Order order) {
        if (order.getStrategyType() == null) {
            throw new InvalidInputException("StrategyType is required for placing an order.");
        }
        return placeOrder(order.getUserName(), order.getItems(), order.getStrategyType());
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void markOrderAsCompleted(String orderId) {
        Order order = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new InvalidInputException("Order not found"));

        if (order.getStatus() == OrderStatus.COMPLETED) {
            throw new InvalidInputException("Order is already completed");
        }

        order.setStatus(OrderStatus.COMPLETED);
        Restaurant r = order.getAssignedRestaurant();
        r.setCurrentOrders(r.getCurrentOrders() - 1);
    }

    private int calculateTotal(Restaurant restaurant, Map<String, Integer> items) {
        return items.entrySet().stream()
                .mapToInt(entry -> restaurant.getMenu().get(entry.getKey()).getPrice() * entry.getValue())
                .sum();
    }
}
