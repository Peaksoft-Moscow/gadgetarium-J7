package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.service.ComparisonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


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

//    @GetMapping("/smartphones")
//    public List<ProductResponse> getSmartPhones(@RequestParam(required = false) boolean difference, Principal principal) {
//        return comparisonService.getSmartPhones(true, principal);
//    }

//
//    @GetMapping("/appWatch")
//    public List<ProductResponse> getHeadphones(@RequestParam(required = false) boolean difference, Principal principal){
//        return null;
//    }
//
//    @GetMapping("/laptops")
//    public List<ProductResponse> getLaptops(@RequestParam(required = false) boolean difference, Principal principal){
//        return null;
//    }
}