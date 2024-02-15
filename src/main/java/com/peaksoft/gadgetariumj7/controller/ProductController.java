package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.BrandRequest;
import com.peaksoft.gadgetariumj7.model.dto.BrandResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductRequest;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Tag(name = "Product")
@SecurityRequirement(name = "Authorization")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "create product")
    @PostMapping("/create")
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @Operation(summary = "create brand")
    @PostMapping("/createBrand")
    public BrandResponse createBrand(@RequestBody BrandRequest request) {
        return productService.createBrand(request);
    }

    @Operation(summary = "get All products")
    @GetMapping("/getAll")
    public List<ProductResponse> getAll() {
        return productService.getAllProducts();
    }

    @Operation(summary = "get products by Id")
    @GetMapping("/getById/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @Operation(summary = "update product by Id")
    @PutMapping("/updateById/{id}")
    public ProductResponse updateById(@RequestBody ProductRequest request, @PathVariable("id") Long id) {
        return productService.updateProductById(id, request);
    }

    @Operation(summary = "delete product by Id")
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "deleted";
    }

    @GetMapping("/filter")
    public List<ProductResponse> getFilteredProduct(
            @RequestParam(value = "brand", required = false) List<String> brand,
            @RequestParam(value = "price", required = false) List<Integer> prices,
            @RequestParam(value = "color", required = false) List<String> color,
            @RequestParam(value = "memory", required = false) List<String> memories,
            @RequestParam(value = "operationMemory", required = false) List<String> operationMemory
    ) {
        return productService.getFilteredProduct(brand, prices, color, memories, operationMemory);
    }

    @GetMapping("/resetFilter")
    public List<ProductResponse> resetFilter() {
        return productService.getAllProducts();
    }
}


