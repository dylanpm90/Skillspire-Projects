package net.skillspire.products;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@Service
public class ProductService {
    private final ProductRepository repo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders = new ArrayList<>();

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product p) {
        return repo.save(p);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product changes) {
        Product existing = repo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setId(changes.getId());
        existing.setName(changes.getName());
        existing.setCategory(changes.getCategory());
        existing.setPrice(changes.getPrice());
        existing.setStockQuantity(changes.getStockQuantity());

        return repo.save(existing);
    }

    public List<Order> getOrders(){
        return orders;
    }

    public boolean deleteProduct(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public List<Product> search(String category){
        if(category == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        return repo.findByCategory(category);
    }


}
