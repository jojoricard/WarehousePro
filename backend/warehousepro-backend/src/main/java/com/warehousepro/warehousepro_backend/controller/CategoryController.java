package com.warehousepro.warehousepro_backend.controller;

import com.warehousepro.warehousepro_backend.entity.Category;
import com.warehousepro.warehousepro_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing Category entities.
 * Exposes REST endpoints for category operations.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Retrieves all categories.
     *
     * @return List of all categories.
     */
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id The ID of the category.
     * @return The category if found, otherwise a 404 error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new category.
     *
     * @param category The category to create.
     * @return The created category.
     */
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    /**
     * Updates an existing category.
     *
     * @param id       The ID of the category to update.
     * @param category The updated category data.
     * @return The updated category.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> existingCategory = categoryService.getCategoryById(id);
        if (existingCategory.isPresent()) {
            category.setId(id);
            return ResponseEntity.ok(categoryService.saveCategory(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return A 204 No Content response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
