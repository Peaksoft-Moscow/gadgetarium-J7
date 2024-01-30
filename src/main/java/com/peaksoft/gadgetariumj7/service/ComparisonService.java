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


    public ProductResponse addToComparison(Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).
                orElseThrow(() -> new RuntimeException("not found User" + principal.getName()));
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("not found Product id" + id));
        List<Product> products = new ArrayList<>();
        products.add(product);
        user.setProductComparison(products);
        userRepository.save(user);
        return productMapper.mapToResponse(product);
    }

    public List<ProductResponse> getSmartPhones(boolean difference, Principal principal) {
        userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("User with email not found" + principal.getName()));


    }
    public List<ProductResponse> getProductResponse(List<Product> products) {
        return products.stream()
                .map(productMapper::mapToResponse)
                .collect(Collectors.toList());
    }


//    public List<ProductResponse> getLaptops(boolean difference, Principal principal) {
//        return null;
//    }
//
//    public List<ProductResponse> getHeadphones(boolean difference, Principal principal) {
//        return null;

//    }
//    public List<ProductResponse> getCategory(boolean difference, Principal principal) {
//        User user = userRepository.findByEmail(principal.getName())
//                .orElseThrow(() -> new EntityNotFoundException("User with email not found" + principal.getName()));
//        List<Product> products = productRepository.getProductsByListIds(user.getId());
//        if (difference) {
//            List<Product> distinctProducts = new ArrayList<>();
//            for (int i = 0; i < products.size(); i++) {
//                if (i == 0 || !isEqual(products.get(i), products.get(i - 1))) {
//                    distinctProducts.add(products.get(i));
//                }
//            }
//            return getProductResponse(distinctProducts);
//        }
//        return getProductResponse(products);
//    }
//
//    private boolean isEqual(Product product1, Product product2) {
//        return product1.getBrandOfProduct().equals(product2.getBrandOfProduct()) &&
//                product1.getScreen().equals(product2.getScreen()) &&
//                product1.getColor().equals(product2.getColor()) &&
//                product1.getOperationSystem().equals(product2.getOperationSystem()) &&
//                product1.getMemory().equals(product2.getMemory()) &&
//                product1.getWeight() == product2.getWeight() &&
//                product1.getSimCard().equals(product2.getSimCard());
//
//    }


//    public void deleteProducts(Principal principal) {
//        User user = userRepository.findByEmail(principal.getName())
//                .orElseThrow(() -> new EntityNotFoundException("not found User name" + principal.getName()));
//        List<Product> productList = productRepository.getProsuct(user.getId());
//        productList.clear();
//        userRepository.save(user);
//    }
}
