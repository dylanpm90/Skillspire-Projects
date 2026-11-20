package net.skillspire.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByIdAndCustomer_Id(Long orderId, Long customerId);
}
