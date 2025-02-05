package com.warehousepro.warehousepro_backend.controller;

import com.warehousepro.warehousepro_backend.entity.StockMovement;
import com.warehousepro.warehousepro_backend.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing StockMovement entities.
 * Exposes REST endpoints for stock movement operations.
 */
@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    /**
     * Retrieves all stock movements.
     *
     * @return List of all stock movements.
     */
    @GetMapping
    public List<StockMovement> getAllStockMovements() {
        return stockMovementService.getAllStockMovements();
    }

    /**
     * Retrieves a stock movement by its ID.
     *
     * @param id The ID of the stock movement.
     * @return The stock movement if found, otherwise a 404 error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
        Optional<StockMovement> stockMovement = stockMovementService.getStockMovementById(id);
        return stockMovement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new stock movement.
     *
     * @param stockMovement The stock movement to create.
     * @return The created stock movement.
     */
    @PostMapping
    public StockMovement createStockMovement(@RequestBody StockMovement stockMovement) {
        return stockMovementService.saveStockMovement(stockMovement);
    }

    /**
     * Updates an existing stock movement.
     *
     * @param id            The ID of the stock movement to update.
     * @param stockMovement The updated stock movement data.
     * @return The updated stock movement.
     */
    @PutMapping("/{id}")
    public ResponseEntity<StockMovement> updateStockMovement(@PathVariable Long id, @RequestBody StockMovement stockMovement) {
        Optional<StockMovement> existingStockMovement = stockMovementService.getStockMovementById(id);
        if (existingStockMovement.isPresent()) {
            stockMovement.setId(id);
            return ResponseEntity.ok(stockMovementService.saveStockMovement(stockMovement));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a stock movement by its ID.
     *
     * @param id The ID of the stock movement to delete.
     * @return A 204 No Content response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return ResponseEntity.noContent().build();
    }
}
