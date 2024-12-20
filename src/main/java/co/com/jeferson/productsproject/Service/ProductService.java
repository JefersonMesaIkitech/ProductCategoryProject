package co.com.jeferson.productsproject.Service;


import co.com.jeferson.productsproject.Mapper.ProductMapper;
import co.com.jeferson.productsproject.Model.Product;
import co.com.jeferson.productsproject.Repository.CategoryRepository;
import co.com.jeferson.productsproject.Repository.ProductRepository;
import co.com.jeferson.productsproject.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    //Service to get all the products
    public Flux<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .map(productMapper::toDTO);
    }

    //Service to create or update all the fields (except the stock) if the product already exists
    public Mono<ProductDTO> createOrUpdateByAllFieldsExceptStock(ProductDTO productDTO) {
        return categoryRepository.findByName(productDTO.getCategoryName())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "La categoría no existe")))
                .flatMap(category -> productRepository.findByNameAndDescriptionAndCategoryNameAndPriceAndWeightAndBrand(
                                productDTO.getName(),
                                productDTO.getDescription(),
                                productDTO.getCategoryName(),
                                productDTO.getPrice(),
                                productDTO.getWeight(),
                                productDTO.getBrand()
                        )
                        .flatMap(existingProduct -> {
                            existingProduct.setStock(existingProduct.getStock() + productDTO.getStock());
                            return productRepository.save(existingProduct);
                        })
                        .switchIfEmpty(Mono.defer(() -> {
                            Product newProduct = productMapper.toEntity(productDTO);
                            return productRepository.save(newProduct);
                        }))
                        .map(productMapper::toDTO));
    }

    public Mono<ProductDTO> getProductById(String id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO);
    }

    public Mono<ProductDTO> updateProduct(String id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    if (productDTO.getName() != null) existingProduct.setName(productDTO.getName());
                    if (productDTO.getDescription() != null) existingProduct.setDescription(productDTO.getDescription());
                    if (productDTO.getPrice() != 0.0) existingProduct.setPrice(productDTO.getPrice());
                    if (productDTO.getStock() != 0) existingProduct.setStock(productDTO.getStock());
                    if (productDTO.getWeight() != 0.0f) existingProduct.setWeight(productDTO.getWeight());
                    if (productDTO.getBrand() != null) existingProduct.setBrand(productDTO.getBrand());
                    return productRepository.save(existingProduct);
                })
                .map(productMapper::toDTO);
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }

}
