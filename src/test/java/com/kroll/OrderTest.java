package com.kroll;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class OrderTest {

    @Test
    void testCalculateTotalPrice() {
        Order order = new Order(1, 1);
        Product product1 = new Product(1, "TestProduct1", 10.0, 5);
        Product product2 = new Product(2, "TestProduct2", 15.0, 3);

        Map<Product, Integer> orderDetails = new HashMap<>();
        orderDetails.put(product1, 2);
        orderDetails.put(product2, 1);

        order.getOrderDetails().putAll(orderDetails);
        order.calculateTotalPrice();

        assertEquals(35.0, order.getTotalPrice());
    }

}
