package com.kroll;

import java.util.HashMap;
import java.util.Map;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;
    private static int userIdCounter = 1;
    private static int productIdCounter = 1;
    private static int orderIdCounter = 1;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public int generateUserId() {
        return userIdCounter++;
    }

    public int generateProductId() {
        return productIdCounter++;
    }

    public int generateOrderId() {
        return orderIdCounter++;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId, Map<Product, Integer> orderDetails) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.getStock() < quantity) {
                System.out.println("Not enough stock for product: " + product.getName());
                return;
            }
        }

        Order order = new Order(generateOrderId(), userId);
        order.getOrderDetails().putAll(orderDetails);
        order.calculateTotalPrice();

        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setStock(product.getStock() - quantity);
        }

        orders.put(order.getId(), order);
        user.getCart().clear();

        System.out.println("Order created successfully. Order ID: " + order.getId());
    }

    public void listAvailableProducts() {
        System.out.println("Available Products:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void listUsers() {
        System.out.println("Users:");
        for (User user : users.values()) {
            System.out.println("User ID: " + user.getId() + ", Username: " + user.getUsername());
        }
    }

    public void listOrders() {
        System.out.println("Orders:");
        for (Order order : orders.values()) {
            System.out.println("Order ID: " + order.getId() + ", User ID: " + order.getUserId() +
                    ", Total Price: $" + order.getTotalPrice());
        }
    }

    public void updateProductStock(Integer productId, int newStock) {
        Product product = products.get(productId);
        if (product != null) {
            product.setStock(newStock);
        } else {
            System.out.println("Product not found");
        }
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }

    public Product getProductById(int productId) {
        return products.get(productId);
    }
}
