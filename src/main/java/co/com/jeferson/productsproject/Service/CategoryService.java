package co.com.jeferson.productsproject.Service;

import co.com.jeferson.productsproject.Mapper.CategoryMapper;
import co.com.jeferson.productsproject.Repository.CategoryRepository;
import co.com.jeferson.productsproject.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    //Service to get all the created categories
    public Flux<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .map(categoryMapper::toDTO);
    }

    //Service to get a single category by its id
    public Mono<CategoryDTO> getCategoryById(String id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO);
    }

    //Service to create a new category
    public Mono<CategoryDTO> createCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(categoryMapper.toEntity(categoryDTO))
                .map(categoryMapper::toDTO);
    }

    //Service to update an existing category by its id
    public Mono<CategoryDTO> updateCategory(String id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id)
                .flatMap(existingCategory -> {
                    if (categoryDTO.getName() != null) existingCategory.setName(categoryDTO.getName());
                    if (categoryDTO.getDescription() != null) existingCategory.setDescription(categoryDTO.getDescription());
                    return categoryRepository.save(existingCategory);
                })
                .map(categoryMapper::toDTO);
    }

    //Service to delete a category by its id
    public Mono<Void> deleteCategory(String id) {
        return categoryRepository.deleteById(id);
    }

}
