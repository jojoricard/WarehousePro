package com.warehousepro.warehousepro_backend.repository;

import com.warehousepro.warehousepro_backend.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing StockMovement entities.
 * Provides CRUD operations and custom query methods.
 */
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    // Custom query methods can be added here if needed
}
