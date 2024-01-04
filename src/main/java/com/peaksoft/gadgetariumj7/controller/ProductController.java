package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.BrandRequest;
import com.peaksoft.gadgetariumj7.model.dto.BrandResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductRequest;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

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
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }
    @PutMapping("/updateById/{id}")
    public ProductResponse updateById(@RequestBody ProductRequest request, @PathVariable("id") Long id) {
        return productService.updateProductById(id, request);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){
         productService.deleteProductById(id);
         return "deleted";

    }


}
