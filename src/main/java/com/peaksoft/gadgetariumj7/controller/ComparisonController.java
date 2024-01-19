package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import com.peaksoft.gadgetariumj7.service.ComparisonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComparisonController {

    UserRepository userRepository;
    ComparisonService comparisonService;

    @GetMapping("/comparison")
    public AuthResponse getComparison(Principal principal) {
        return comparisonService.getCompare(principal);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductResponse>> compareCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "false") boolean difference,
            Principal principal) {
        List<ProductResponse> response;
        try {
            response = comparisonService.getCategory(difference,category, principal);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}