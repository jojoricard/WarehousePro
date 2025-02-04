package com.warehousepro.warehousepro_backend.repository;

import com.warehousepro.warehousepro_backend.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Warehouse entities.
 * Provides CRUD operations and custom query methods.
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    // Custom query methods can be added here if needed
}
