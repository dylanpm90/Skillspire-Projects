package net.skillspire.products;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping // get all products
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}") // get a product by its id
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long product_id){
        Product product = productService.getProduct(product_id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("{id}/category")
    public ResponseEntity<String> getProductCategory(@PathVariable("id") Long product_id){
        String category = productService.getProductCategory(product_id);

        return ResponseEntity.ok(category);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam(value = "category", required = false) String category, @RequestParam(name = "max price", defaultValue = "100") double maxPrice){
        return productService.search(category,maxPrice);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product saved = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long product_id,
                                                 @RequestBody Product product){
        Product updated = productService.updateProduct(product_id, product);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long product_id){
        if (productService.deleteProduct(product_id)){
            return ResponseEntity.ok("Product " + product_id + " deleted.");
        }
        return ResponseEntity.notFound().build();
    }

}
