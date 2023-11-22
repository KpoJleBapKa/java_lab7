package com.kroll;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        int currentQuantity = cart.getOrDefault(product, 0);
        if (currentQuantity - quantity > 0) {
            cart.put(product, currentQuantity - quantity);
        } else {
            cart.remove(product);
        }
    }

    public void updateCart(Product product, int quantity) {
        cart.put(product, quantity);
    }
}


