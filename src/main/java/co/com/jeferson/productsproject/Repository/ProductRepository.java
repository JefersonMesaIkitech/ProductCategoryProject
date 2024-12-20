package co.com.jeferson.productsproject.Repository;

import co.com.jeferson.productsproject.Model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    // Find a product by name, description, category name, price, weight and brand

    Mono<Product> findByNameAndDescriptionAndCategoryNameAndPriceAndWeightAndBrand(
            String name,
            String description,
            String categoryName,
            double price,
            float weight,
            String brand
    );
}
