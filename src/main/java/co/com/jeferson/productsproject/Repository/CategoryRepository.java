package co.com.jeferson.productsproject.Repository;

import co.com.jeferson.productsproject.Model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
    //Get a single category by its name
    Mono<Category> findByName(String name);
}
