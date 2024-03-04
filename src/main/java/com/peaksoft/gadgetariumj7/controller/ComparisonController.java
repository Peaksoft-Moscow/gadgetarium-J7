package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.ComparisonResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.enums.Category;
import com.peaksoft.gadgetariumj7.service.impl.ComparisonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comparison")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComparisonController {

    ComparisonService comparisonService;

    @PostMapping("/{id}")
    public ProductResponse addComparison(@PathVariable("id") Long productId, Principal principal) {
        return comparisonService.addToComparison(productId, principal);
    }

    @GetMapping()
    public List<ComparisonResponse> getComparisonByCategory(@RequestParam Category category, Principal principal) {
        return comparisonService.getComparisonByCategory(category, principal);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Principal principal) {
        comparisonService.deleteProducts(principal);
        return ResponseEntity.ok().body("Successfully");
    }

    @GetMapping("/unique")
    public List<ComparisonResponse> uniqProducts(@RequestParam Category category, Principal principal) {
        return comparisonService.getComparisonByCategory(category, principal);
    }

    @GetMapping("/distinct")
    public Stream<String> getDistinct() {
        return comparisonService.getDistinctProducts();
    }

    @GetMapping()
    public List<ProductResponse> getProductByUserId(Principal principal) {
        return comparisonService.getMyProductComparison(principal);
    }

    @DeleteMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return comparisonService.findById(id);
    }

}