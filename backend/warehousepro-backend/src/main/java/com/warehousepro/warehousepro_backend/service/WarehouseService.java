package com.warehousepro.warehousepro_backend.service;

import com.warehousepro.warehousepro_backend.entity.Warehouse;
import com.warehousepro.warehousepro_backend.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Warehouse entities.
 * Contains business logic for warehouse operations.
 */
@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    /**
     * Retrieves all warehouses.
     *
     * @return List of all warehouses.
     */
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    /**
     * Retrieves a warehouse by its ID.
     *
     * @param id The ID of the warehouse.
     * @return The warehouse if found, otherwise null.
     */
    public Optional<Warehouse> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

    /**
     * Saves a warehouse.
     *
     * @param warehouse The warehouse to save.
     * @return The saved warehouse.
     */
    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    /**
     * Deletes a warehouse by its ID.
     *
     * @param id The ID of the warehouse to delete.
     */
    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
