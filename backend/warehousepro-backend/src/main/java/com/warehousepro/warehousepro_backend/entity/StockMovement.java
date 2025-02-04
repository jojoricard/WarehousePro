package com.warehousepro.warehousepro_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Represents a stock movement (entry or exit) in the warehouse.
 * Each movement has a unique ID, a type (entry/exit), a quantity, a date, and is associated with a product.
 */
@Entity
@Getter
@Setter
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // "ENTRY" or "EXIT"

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
