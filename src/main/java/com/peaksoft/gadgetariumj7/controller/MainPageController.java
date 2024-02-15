package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.MainPageResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.service.MainPageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main-page")
@Tag(name = "Main - page")
@SecurityRequirement(name = "Authorization")
public class MainPageController {
    private final MainPageService mainPageService;

    @Operation(summary = "get  products by status : newDevices, sale, recommend")
    @GetMapping()
    MainPageResponse getAllMainPage() {
        return mainPageService.getALlMainPage();
    }

    @Operation(summary = "products by newDevice")
    @GetMapping("/newDevice")
    List<ProductResponse> getProductByStatusNewDevices() {
        return mainPageService.getProductByStatusNewDevices();
    }

    @Operation(summary = "products by sale")
    @GetMapping("/sale")
    List<ProductResponse> getProductByStatusSale() {
        return mainPageService.getProductByStatusSale();
    }

    @Operation(summary = "products by recommend")
    @GetMapping("/recommend")
    List<ProductResponse> getProductByStatusRecommend() {
        return mainPageService.getProductByStatusRecommend();
    }
}

