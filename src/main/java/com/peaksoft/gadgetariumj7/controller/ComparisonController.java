package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.service.ComparisonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
    public List<ProductResponse> getProductByUserId(Principal principal) {
        return comparisonService.getMyComparisonProduct(principal);
    }

    @GetMapping("/smartphones")
    public List<ProductResponse> getSmartPhones() {
        return comparisonService.getSmartPhones();
    }

    @GetMapping("/head")
    public List<ProductResponse> getHeadphones() {
        return comparisonService.getHeadphones();
    }

    @GetMapping("/laptops")
    public List<ProductResponse> getLaptops() {
        return comparisonService.getLaptops();
    }

    @GetMapping("/distinct")
    public Stream<String> getDistinct(){
        return comparisonService.getDistinctProducts();
    }
}