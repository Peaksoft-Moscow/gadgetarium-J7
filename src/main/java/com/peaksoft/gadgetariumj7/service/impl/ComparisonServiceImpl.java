package com.peaksoft.gadgetariumj7.service.impl;

import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
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
    public ProductResponse addComparison(Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("not found User :" + principal.getName()));
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found product id" + id));
        List<Product> products = user.getProductComparison();
        products.add(product);
        user.setProductComparison(products);
        userRepository.save(user);
        return mapper.mapToResponse(product);
    }

    @Override
    public List<ProductResponse> getComparisonByCategory(CategoryType categoryType, Principal principal) {
        return null;
    }

    @Override
    public void getClear(Principal principal) {

    }
}
