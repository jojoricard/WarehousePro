package com.warehousepro.warehousepro_backend.service;

import com.warehousepro.warehousepro_backend.entity.StockMovement;
import com.warehousepro.warehousepro_backend.repository.StockMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing StockMovement entities.
 * Contains business logic for stock movement operations.
 */
@Service
public class StockMovementService {

    @Autowired
    private StockMovementRepository stockMovementRepository;

    /**
     * Retrieves all stock movements.
     *
     * @return List of all stock movements.
     */
    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    /**
     * Retrieves a stock movement by its ID.
     *
     * @param id The ID of the stock movement.
     * @return The stock movement if found, otherwise null.
     */
    public Optional<StockMovement> getStockMovementById(Long id) {
        return stockMovementRepository.findById(id);
    }

    /**
     * Saves a stock movement.
     *
     * @param stockMovement The stock movement to save.
     * @return The saved stock movement.
     */
    public StockMovement saveStockMovement(StockMovement stockMovement) {
        return stockMovementRepository.save(stockMovement);
    }

    /**
     * Deletes a stock movement by its ID.
     *
     * @param id The ID of the stock movement to delete.
     */
    public void deleteStockMovement(Long id) {
        stockMovementRepository.deleteById(id);
    }
}
