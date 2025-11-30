package com.example.labclients.lab_clients.infrastructure.rest;

import com.example.labclients.lab_clients.application.dto.ProductDTO;
import com.example.labclients.lab_clients.application.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getProducts() {
        return this.productService.findAll();
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.save(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public boolean getIsAvailable(@PathVariable Long id) {
        return this.productService.isAvailable(id);
    }

    @GetMapping("/product/{id} ")
    public Integer getProductStock(@PathVariable Long id) {
        return this.productService.getStock(id);
    }

}
