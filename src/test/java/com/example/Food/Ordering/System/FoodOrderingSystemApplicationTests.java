package com.example.foodordering;

import com.example.foodordering.service.OrderService;
import com.example.foodordering.service.RestaurantService;
import com.example.foodordering.service.strategy.StrategyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class FoodOrderingSystemApplicationTests {

    @MockBean
    private RestaurantService restaurantService;

    @MockBean
    private StrategyFactory strategyFactory;

    @Test
    void contextLoads() {
        
    }
}
