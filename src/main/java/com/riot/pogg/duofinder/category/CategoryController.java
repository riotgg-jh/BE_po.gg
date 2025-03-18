package com.riot.pogg.duofinder.category;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{categoryType}")
    public List<Category> getCategoriesByType(@PathVariable CategoryType categoryType) {
        return categoryRepository.findByCategoryType(categoryType);
    }
}
