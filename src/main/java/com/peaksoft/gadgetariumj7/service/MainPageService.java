package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.MainPageResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainPageService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public MainPageResponse getALlMainPage() {
        MainPageResponse mainPageResponses = new MainPageResponse();
        List<Product> newDevices = productRepository.findByStatusNewDevice();
        List<Product> sale = productRepository.findByStatusSale();
        List<Product> recommend = productRepository.findByStatusRecommend();
        mainPageResponses.setNewDevice(newDevices.stream().map(productMapper::mapToResponse).toList());
        mainPageResponses.setSale(sale.stream().map(productMapper::mapToResponse).toList());
        mainPageResponses.setRecommend(recommend.stream().map(productMapper::mapToResponse).toList());
        return mainPageResponses;
    }

    public List<ProductResponse> getProductByStatusNewDevices() {
        List<Product> newDevices = productRepository.findByStatusNewDevice();
        return newDevices.stream().map(productMapper::mapToResponse).toList();
    }

    public List<ProductResponse> getProductByStatusSale() {
        List<Product> sale = productRepository.findByStatusSale();
        return sale.stream().map(productMapper::mapToResponse).toList();
    }

    public List<ProductResponse> getProductByStatusRecommend() {
        List<Product> recommend = productRepository.findByStatusRecommend();
        return recommend.stream().map(productMapper::mapToResponse).toList();
    }
}
