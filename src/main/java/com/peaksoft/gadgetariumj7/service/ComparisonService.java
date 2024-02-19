package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComparisonService {

    ProductMapper productMapper;
    ProductRepository productRepository;
    UserRepository userRepository;

    public ProductResponse addToComparison(Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).
                orElseThrow(() -> new RuntimeException("not found User" + principal.getName()));
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("not found Product id" + id));
        List<Product> products = user.getProductComparison();
        products.add(product);
        user.setProductComparison(products);
        userRepository.save(user);
        return productMapper.mapToResponse(product);
    }

    public List<ProductResponse> getMyComparisonProduct(Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).
                orElseThrow(() -> new RuntimeException("Пользователь не найден: " + principal.getName()));
        List<Product> products = productRepository.getProductComparisonByUserId(user.getId());
        return getProductResponse(products);
    }

    public List<ProductResponse> getSmartPhones() {
        List<Product> smartPhones = productRepository.getSmartphones();
        return getProductResponse(smartPhones);
    }

    public List<ProductResponse> getHeadphones() {
        List<Product> headPhones = productRepository.getHeadPhones();
        return getProductResponse(headPhones);
    }

    public List<ProductResponse> getLaptops() {
        List<Product> laptops = productRepository.getLapTops();
        return getProductResponse(laptops);
    }

    public List<ProductResponse> getProductResponse(List<Product> products) {
        return products.stream()
                .map(productMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public Stream<String> getDistinctProducts() {
         List<String> disting =productRepository.distinctProducts();
        return disting.stream().distinct();
    }
}