package net.skillspire.relationships;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerProfileTest {
    @Autowired
    private CustomerRepository customers;

    @Autowired
    private EntityManager entityManager;

    @Test
    void savingCustomerPersistsProfileAndReloadsBothDirections() {
        Customer saved = customers.saveAndFlush(new Customer(
                "Ada", new Profile("123 Main St", "555-0100")));
        Long customerId = saved.getId();
        Long profileId = saved.getProfile().getId();
        assertThat(profileId).isNotNull();
        entityManager.clear();

        Customer reloaded = customers.findById(customerId).orElseThrow();
        assertThat(reloaded.getProfile().getId()).isEqualTo(profileId);
        assertThat(reloaded.getProfile().getAddress()).isEqualTo("123 Main St");
        assertThat(reloaded.getProfile().getCustomer().getId()).isEqualTo(customerId);
    }

    @Test
    void removingCustomerAlsoRemovesItsPrivateProfile() {
        Customer saved = customers.saveAndFlush(new Customer(
                "Grace", new Profile("456 Oak St", "555-0101")));
        Long customerId = saved.getId();
        Long profileId = saved.getProfile().getId();
        entityManager.clear();

        customers.deleteById(customerId);
        customers.flush();
        entityManager.clear();

        assertThat(customers.findById(customerId)).isEmpty();
        assertThat(entityManager.find(Profile.class, profileId)).isNull();
    }

    @Test
    void customerWithTwoOrdersReloadsBoth(){
        Customer customer1 = new Customer(
                "Grace", new Profile("456 Oak St", "555-0101"));
        customer1.addOrder(new Order("keyboard", new BigDecimal(99.99)));
        customer1.addOrder((new Order("mouse", new BigDecimal(28.99))));

        Long id = customers.saveAndFlush(customer1).getId();
        entityManager.clear();

        Customer reloaded = customers.findById(id).orElseThrow();

        assertThat(customer1.getOrders())
                .extracting(Order::getProduct)
                .containsExactlyInAnyOrder("keyboard", "mouse");
    }
}
