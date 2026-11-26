package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceUnitTest {
    private final OrderService orders = new OrderService();

    @Test
    void previewsProductWithoutSpring() {
        assertEquals("Order preview for Keyboard", orders.placeOrder("Keyboard"));
    }

    @Test
    void rejectsBlankProduct() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> orders.placeOrder(" "));
        assertEquals("Product is required", ex.getMessage());
    }
}
