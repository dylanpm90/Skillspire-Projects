package net.skillspire.relationships;

import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@org.springframework.context.annotation.Profile("demo")
public class RelationshipDemo implements CommandLineRunner {
    private final CustomerRepository customers;
    private final EntityManager entityManager;

    public RelationshipDemo(CustomerRepository customers, EntityManager entityManager) {
        this.customers = customers;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) {
        Customer saved = customers.saveAndFlush(new Customer(
                "Ada", new Profile("123 Main St", "555-0100")));
        Long id = saved.getId();
        entityManager.clear();

        Customer reloaded = customers.findById(id).orElseThrow();
        System.out.printf("Customer %s -> profile %d at %s%n",
                reloaded.getName(), reloaded.getProfile().getId(),
                reloaded.getProfile().getAddress());
        System.out.printf("Inverse link -> customer %d%n",
                reloaded.getProfile().getCustomer().getId());
    }
}
