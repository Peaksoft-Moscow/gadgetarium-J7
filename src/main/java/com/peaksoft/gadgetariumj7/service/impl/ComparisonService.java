package com.peaksoft.gadgetariumj7.service.impl;

import com.peaksoft.gadgetariumj7.mapper.ComparisonMapper;
import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.ComparisonResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.enums.CategoryType;
import com.peaksoft.gadgetariumj7.repository.ComparisonRepository;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComparisonService {

    ProductRepository productRepository;
    ComparisonRepository comparisonRepository;
    UserRepository userRepository;
    ProductMapper productMapper;
    ComparisonMapper comparisonMapper;

    public ProductResponse addToComparison(Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("not found User :" + principal.getName()));
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found product id" + id));
        List<Product> products = user.getProductComparison();
        products.add(product);
        user.setProductComparison(products);
        userRepository.save(user);
        return productMapper.mapToResponse(product);
    }

    public List<ProductResponse> getMyProductComparison(Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("not found User :" + principal.getName()));
        List<Product> products = comparisonRepository.getProductComparisonByUserId(user.getId());
        return getProductResponse(products);
    }

    public List<ComparisonResponse> getComparisonByCategory(CategoryType categoryType, Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("not found User :" + principal.getName()));
        Map<CategoryType, List<ComparisonResponse>> categoryMap = new HashMap<>();
        categoryMap.put(CategoryType.SMARTPHONES, comparisonMapper.mapToResponse(comparisonRepository.smartphones(user.getId())));
        categoryMap.put(CategoryType.LAPTOPS, comparisonMapper.mapToResponse(comparisonRepository.laptops(user.getId())));
        categoryMap.put(CategoryType.HEADPHONES, comparisonMapper.mapToResponse(comparisonRepository.headphones(user.getId())));
        return categoryMap.getOrDefault(categoryType, null);
    }

    public void deleteProducts(Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).get();
        user.setProductComparison(null);
        userRepository.save(user);
        userRepository.delete(user);
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found id :" + id));
        return productMapper.mapToResponse(product);
    }

    public Stream<String> getDistinctProducts() {
        List<String> disting = comparisonRepository.distinctProducts();
        return disting.stream().distinct();
    }

    public List<ProductResponse> getProductResponse(List<Product> products) {
        return products.stream()
                .map(productMapper::mapToResponse)
                .collect(Collectors.toList());
    }

}
