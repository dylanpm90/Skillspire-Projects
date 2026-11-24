package net.skillspire.relationships;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String placeOrder(String product) {
        if (product == null || product.isBlank()) {
            throw new IllegalArgumentException("Product is required");
        }
        return "Order preview for " + product;
    }

    public String status() {
        return "Order service ready";
    }

    public String placeFromInside(String product) {
        return this.placeOrder(product);
    }
}
