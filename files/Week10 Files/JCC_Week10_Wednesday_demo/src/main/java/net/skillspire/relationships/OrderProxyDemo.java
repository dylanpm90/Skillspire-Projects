package net.skillspire.relationships;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("demo")
public class OrderProxyDemo implements CommandLineRunner {
    private final OrderService orders;

    public OrderProxyDemo(OrderService orders) {
        this.orders = orders;
    }

    // TODO: Predict which calls trigger advice for only OrderService.placeOrder(..).
    @Override
    public void run(String... args) {
        System.out.println("Direct call: " + orders.placeOrder("Keyboard"));
        System.out.println("Nonmatching call: " + orders.status());
        System.out.println("Self-invocation: " + orders.placeFromInside("Mouse"));
    }
}
