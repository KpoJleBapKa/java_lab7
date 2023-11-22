package com.kroll;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void calculateTotalPrice() {
        totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
