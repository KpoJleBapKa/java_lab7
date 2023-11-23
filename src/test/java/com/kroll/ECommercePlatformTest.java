package com.kroll;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ECommercePlatformTest {

    @Test
    void testGenerateUserId() {
        ECommercePlatform platform = new ECommercePlatform();
        int userId1 = platform.generateUserId();
        int userId2 = platform.generateUserId();

        assertNotEquals(userId1, userId2);
    }

    @Test
    void testGenerateProductId() {
        ECommercePlatform platform = new ECommercePlatform();
        int productId1 = platform.generateProductId();
        int productId2 = platform.generateProductId();

        assertNotEquals(productId1, productId2);
    }

    @Test
    void testGenerateOrderId() {
        ECommercePlatform platform = new ECommercePlatform();
        int orderId1 = platform.generateOrderId();
        int orderId2 = platform.generateOrderId();

        assertNotEquals(orderId1, orderId2);
    }

}
