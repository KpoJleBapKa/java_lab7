package com.kroll;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testAddToCart() {
        User user = new User(1, "TestUser");
        Product product = new Product(1, "TestProduct", 10.0, 5);

        user.addToCart(product, 3);

        assertEquals(3, user.getCart().get(product));
    }
    @Test
    void testRemoveFromCart() {
        User user = new User(1, "TestUser");
        Product product = new Product(1, "TestProduct", 10.0, 5);

        user.addToCart(product, 3);
        user.removeFromCart(product, 2);

        assertEquals(1, user.getCart().get(product));
    }

}
