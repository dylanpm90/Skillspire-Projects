package net.skillspire.products;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public  ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping // get all products
    public List<Product>getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}") // get a product by its id
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product p = productService.getProduct(id);
        if (p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product p){
        Product saved = productService.addProduct(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                                 @RequestBody Product p){
        Product updated = productService.updateProduct(id, p);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        if(productService.deleteProduct(id)){
            return ResponseEntity.ok("Product " + id + " deleted.");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/category")
    public ResponseEntity<String> getProductCategory(@PathVariable("id") Long id){
        String category = productService.getProductCategory(id);

        return ResponseEntity.ok(category);
    }

    //`GET /api/products/search?category={category}&maxPrice={maxPrice}`
    // — uses **query/request parameters**
    // (`@RequestParam`) to filter products, with `maxPrice` optional
    // (provide a sensible default).
    @GetMapping("/search")
    public List<Product> search(@RequestParam(value = "category", required = false) String category, @RequestParam(name = "max price", defaultValue = "100") double maxPrice){
        return productService.search(category,maxPrice);
    }

//    @GetMapping("/customers/{customerId}")
//    public ResponseEntity<Order>getOrder(@PathVariable("customer_id") Long customerId){
//        return productService.getCustomer(customerId);
//    }


}
