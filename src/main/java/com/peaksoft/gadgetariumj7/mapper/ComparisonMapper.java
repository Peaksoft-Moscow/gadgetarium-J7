package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.ComparisonResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ComparisonMapper {

    public List<ComparisonResponse> mapToResponse(List<Product> productList) {
        return productList.stream()
                .map(product -> new ComparisonResponse(
                        product.getId(),
                        product.getBrandOfProduct().getBrandName(),
                        product.getScreen(),
                        product.getColor(),
                        product.getOperationSystem(),
                        product.getMemory(),
                        product.getWeight(),
                        product.getSimCard()
                ))
                .collect(Collectors.toList());
    }
}