package co.com.jeferson.productsproject.Controller;

import co.com.jeferson.productsproject.Service.CategoryService;
import co.com.jeferson.productsproject.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    //Get all categories
    @GetMapping
    public Flux<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //Get a single category by its id
    @GetMapping("/{id}")
    public Mono<CategoryDTO> getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    //Create a new category
    @PostMapping
    public Mono<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    //Update an existing category by its id
    @PatchMapping("/{id}")
    public Mono<CategoryDTO> updateCategory(@PathVariable String id, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(id, categoryDTO);
    }

    //Delete a category by its id
    @DeleteMapping("/{id}")
    public Mono<Void> deleteCategory(@PathVariable String id) {
        return categoryService.deleteCategory(id);
    }


}
