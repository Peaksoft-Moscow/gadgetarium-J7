package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.enums.CategoryType;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface ComparisonService {

    ResponseEntity<String> addComparison(Long id, Principal principal);

    List<ProductResponse> getComparisonByCategory(CategoryType categoryType, Principal principal);

    void getClear(Principal principal);
}
