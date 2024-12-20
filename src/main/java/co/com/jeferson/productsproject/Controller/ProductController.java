package co.com.jeferson.productsproject.Controller;

import co.com.jeferson.productsproject.Service.ProductService;
import co.com.jeferson.productsproject.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    // Get all products from the DB
    @GetMapping
    public Flux<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    //Get just one product from the DB by its ID
    @GetMapping("/{id}")
    public Mono<ProductDTO> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    //Create a new product
    @PostMapping
    public Mono<ProductDTO> createOrUpdateProduct(@RequestBody ProductDTO productDTO) {
        return productService.createOrUpdateByAllFieldsExceptStock(productDTO);
    }

    //Partial update to a product
    @PatchMapping("/{id}")
    public Mono<ProductDTO> updateProduct(@PathVariable @RequestBody String id, ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    //Delete a product by its ID
    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

}
