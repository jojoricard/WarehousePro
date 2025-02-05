package com.warehousepro.warehousepro_backend.controller;

import com.warehousepro.warehousepro_backend.entity.Warehouse;
import com.warehousepro.warehousepro_backend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing Warehouse entities.
 * Exposes REST endpoints for warehouse operations.
 */
@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * Retrieves all warehouses.
     *
     * @return List of all warehouses.
     */
    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    /**
     * Retrieves a warehouse by its ID.
     *
     * @param id The ID of the warehouse.
     * @return The warehouse if found, otherwise a 404 error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Optional<Warehouse> warehouse = warehouseService.getWarehouseById(id);
        return warehouse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new warehouse.
     *
     * @param warehouse The warehouse to create.
     * @return The created warehouse.
     */
    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.saveWarehouse(warehouse);
    }

    /**
     * Updates an existing warehouse.
     *
     * @param id        The ID of the warehouse to update.
     * @param warehouse The updated warehouse data.
     * @return The updated warehouse.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        Optional<Warehouse> existingWarehouse = warehouseService.getWarehouseById(id);
        if (existingWarehouse.isPresent()) {
            warehouse.setId(id);
            return ResponseEntity.ok(warehouseService.saveWarehouse(warehouse));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a warehouse by its ID.
     *
     * @param id The ID of the warehouse to delete.
     * @return A 204 No Content response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
