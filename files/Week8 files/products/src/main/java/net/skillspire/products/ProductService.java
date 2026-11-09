package net.skillspire.products;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repo;

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

    public boolean deleteProduct(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
