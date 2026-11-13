package net.skillspire.products;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService service;

    public  ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping // get all products
    public List<Product>getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}") // get a product by its id
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product p = service.getProduct(id);
        if (p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product p){
        Product saved = service.addProduct(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product p){
        Product updated = service.updateProduct(id, p);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        if(service.deleteProduct(id)){
            return ResponseEntity.ok("Product " + id + " deleted.");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam(value = "category", required = false) String category){
        return service.search(category);
    }

}
