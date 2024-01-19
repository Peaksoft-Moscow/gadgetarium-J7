package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.AuthMapper;
import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComparisonService {

    ProductMapper productMapper;
    ProductRepository productRepository;
    UserRepository userRepository;
    AuthMapper authMapper;

    public AuthResponse getCompare(Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("not found User name" + principal.getName()));
        return authMapper.mapToUserResponse(user);
    }

    public List<ProductResponse> getCategory(boolean difference, String category, Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new EntityNotFoundException("User with email not found" + principal.getName()));
        List<Product> products = productRepository.getProductsByListIds(user.getId(),category);
        if (difference) {
            List<Product> distinctProducts = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                if (i == 0 || !isEqual(products.get(i), products.get(i - 1))) {
                    distinctProducts.add(products.get(i));
                }
            }
            return getResponse(distinctProducts);
        }
        return getResponse(products);
    }

    private boolean isEqual(Product product1, Product product2) {
        return product1.getBrandOfProduct().equals(product2.getBrandOfProduct()) &&
                product1.getScreen().equals(product2.getScreen()) &&
                product1.getColor().equals(product2.getColor()) &&
                product1.getOperationSystem().equals(product2.getOperationSystem()) &&
                product1.getMemory().equals(product2.getMemory()) &&
                product1.getWeight() == product2.getWeight() &&
                product1.getSimCard().equals(product2.getSimCard());
    }

    public List<ProductResponse> getResponse(List<Product> products) {
        return products.stream()
                .map(productMapper::mapToResponse)
                .collect(Collectors.toList());
    }

//    public List<Product> getComparedProducts(List<Integer> ids) {
//        return productRepository.getProductsByListIds(ids);
//    }
//
//    public List<List<String>> getComparedProducts(List<Integer> ids, boolean isDifference) {
//        List<Product> productList = productRepository.getProductsByListIds(ids);

//    }
}
