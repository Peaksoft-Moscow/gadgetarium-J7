package com.peaksoft.gadgetariumj7.service.impl;

import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.enums.CategoryType;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import com.peaksoft.gadgetariumj7.service.ComparisonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComparisonServiceImpl implements ComparisonService {

    ProductRepository productRepository;
    UserRepository userRepository;
    ProductMapper mapper;

    @Override
    public ResponseEntity<String> addComparison(Long id, Principal principal) {
        return null;

    }

    @Override
    public List<ProductResponse> getComparisonByCategory(CategoryType categoryType, Principal principal) {
        return null;
    }

    @Override
    public void getClear(Principal principal) {

    }
}
