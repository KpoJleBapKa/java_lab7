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

    public void createOrder(Integer userId, Map<Integer, Integer> productQuantities) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("Користувача не знайдено");
            return;
        }

        Order order = new Order(generateOrderId(), userId);
        for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            Product product = products.get(productId);
            if (product == null) {
                System.out.println("Товар не знайдений");
                return;
            }

            if (product.getStock() < quantity) {
                System.out.println("Недостатньо товару на складі: " + product.getName());
                return;
            }

            order.getOrderDetails().put(product, quantity);
            product.setStock(product.getStock() - quantity);
        }
        order.calculateTotalPrice();

        orders.put(order.getId(), order);
        user.getCart().clear();

        System.out.println("Замовлення створено успішно. ID замовлення: " + order.getId());
    }

    public void displayAvailableProducts() {
        System.out.println("Доступні товари:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void listUsers() {
        System.out.println("Користувачі:");
        for (User user : users.values()) {
            System.out.println("ID користувача: " + user.getId() + ", Ім'я користувача: " + user.getUsername());
        }
    }

    public void listOrders() {
        System.out.println("Замовлення:");
        for (Order order : orders.values()) {
            System.out.println("ID замовлення: " + order.getId() + ", ID користувача: " + order.getUserId() +
                    ", Загальна вартість: $" + order.getTotalPrice());
        }
    }

    public void updateProductStock(Integer productId, int newStock) {
        Product product = products.get(productId);
        if (product != null) {
            product.setStock(newStock);
        } else {
            System.out.println("Товар не знайдено");
        }
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }

    public Product getProductById(int productId) {
        return products.get(productId);
    }
}
