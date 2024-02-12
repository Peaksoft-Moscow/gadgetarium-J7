package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.BrandRequest;
import com.peaksoft.gadgetariumj7.model.dto.BrandResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductRequest;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @PostMapping("/create")
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @PostMapping("/createBrand")
    public BrandResponse createBrand(@RequestBody BrandRequest request) {
        return productService.createBrand(request);
    }


    @GetMapping("/getAll")
    public List<ProductResponse> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/updateById/{id}")
    public ProductResponse updateById(@RequestBody ProductRequest request, @PathVariable("id") Long id) {
        return productService.updateProductById(id, request);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "deleted";
    }

    @GetMapping("/filter")
    public List<ProductResponse> getFilteredProduct(
            @RequestParam(value = "brand", required = false) List<String> brand,
            @RequestParam(value = "price",required = false) List<Integer> prices,
            @RequestParam(value = "color", required = false) List<String> color,
            @RequestParam(value = "memory",required = false) List<String>memories,
            @RequestParam(value = "operationMemory",required = false) List<String> operationMemory
    ) {
        return productService.getFilteredProduct(brand,prices, color,memories,operationMemory);
    }
    @GetMapping("/resetFilter")
    public List<ProductResponse> resetFilter(){
        return productService.getAllProducts();
    }
}


