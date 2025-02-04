package com.warehousepro.warehousepro_backend.repository;

import com.warehousepro.warehousepro_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Product entities.
 * Provides CRUD operations and custom query methods.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods can be added here if needed
}
