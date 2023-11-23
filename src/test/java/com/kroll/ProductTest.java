package com.kroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testSetStock() {
        Product product = new Product(1, "TestProduct", 10.0, 5);
        product.setStock(8);
        assertEquals(8, product.getStock());
    }
    @Test
    void testProductCompareTo() {
        Product product1 = new Product(1, "Product1", 10.0, 5);
        Product product2 = new Product(2, "Product2", 15.0, 3);

        assertTrue(product1.compareTo(product2) < 0);
        assertTrue(product2.compareTo(product1) > 0);
        assertEquals(0, product1.compareTo(product1));
    }
}

