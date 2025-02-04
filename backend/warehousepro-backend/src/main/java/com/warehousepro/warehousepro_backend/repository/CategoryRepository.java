package com.warehousepro.warehousepro_backend.repository;

import com.warehousepro.warehousepro_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Category entities.
 * Provides CRUD operations and custom query methods.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query methods can be added here if needed
}
