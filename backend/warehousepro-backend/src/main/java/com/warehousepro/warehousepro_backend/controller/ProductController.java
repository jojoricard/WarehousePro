package com.warehousepro.warehousepro_backend.controller;

import com.warehousepro.warehousepro_backend.entity.Product;
import com.warehousepro.warehousepro_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing Product entities.
 * Exposes REST endpoints for product operations.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Retrieves all products.
     *
     * @return List of all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product.
     * @return The product if found, otherwise a 404 error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new product.
     *
     * @param product The product to create.
     * @return The created product.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    /**
     * Updates an existing product.
     *
     * @param id      The ID of the product to update.
     * @param product The updated product data.
     * @return The updated product.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            return ResponseEntity.ok(productService.saveProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return A 204 No Content response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
