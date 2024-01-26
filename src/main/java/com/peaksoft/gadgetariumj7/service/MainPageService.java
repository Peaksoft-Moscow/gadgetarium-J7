package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.MainPageResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainPageService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getALlMainPage(){
        MainPageResponse mainPageResponses = new MainPageResponse();
        List<Product> newDevices = productRepository.findByStatusNewDevice();
        newDevices.stream().map(productMapper::mapToResponse).toList();
        List<Product> sale = productRepository.findByStatusSale();
        List<Product> recommend = productRepository.findByStatusRecommend();
        mainPageResponses.setNewDevice(newDevices);
        mainPageResponses.setSale(sale);
        mainPageResponses.setRecommend(recommend);

    }

    public List<ProductResponse> getProductByStatusNewDevices() {
        List<Product> products = productRepository.findAll();
        List<Product> newDevices = productRepository.findByStatusNewDevice();
        for (Product product : products) {
            if (product.getProductStatus().equals("NEW_DEVICES")) {
                return newDevices.stream().map(productMapper::mapToResponse).toList();
            }
        }
        return newDevices.stream().map(productMapper::mapToResponse).toList();
    }

    public List<ProductResponse> getProductByStatusSale() {
        List<Product> products = productRepository.findAll();
        List<Product> sale = productRepository.findByStatusSale();
        for (Product product : products) {
            if (product.getProductStatus().equals("SALES")) {
                return sale.stream().map(productMapper::mapToResponse).toList();
            }
        }
        return sale.stream().map(productMapper::mapToResponse).toList();
    }

    public List<ProductResponse> getProductByStatusRecommend() {
        List<Product> products = productRepository.findAll();
        List<Product> recommend = productRepository.findByStatusRecommend();
        for (Product product : products) {
            if (product.getProductStatus().equals("RECOMMENDATIONS")) {
                return recommend.stream().map(productMapper::mapToResponse).toList();
            }
        }
        return recommend.stream().map(productMapper::mapToResponse).toList();
    }
}
