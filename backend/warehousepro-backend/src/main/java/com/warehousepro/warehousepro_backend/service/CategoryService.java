package com.warehousepro.warehousepro_backend.service;

import com.warehousepro.warehousepro_backend.entity.Category;
import com.warehousepro.warehousepro_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Category entities.
 * Contains business logic for category operations.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Retrieves all categories.
     *
     * @return List of all categories.
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id The ID of the category.
     * @return The category if found, otherwise null.
     */
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Saves a category.
     *
     * @param category The category to save.
     * @return The saved category.
     */
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
