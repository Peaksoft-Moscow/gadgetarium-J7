package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.MainPageResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productStatus")
public class MainPageController {
    private final MainPageService mainPageService;

//    @GetMapping("/newDevice")
//    List<ProductResponse> getProductByStatusNewDevices() {
//        return mainPageService.getProductByStatusNewDevices();
//    }
//
//    @GetMapping("/sale")
//    List<ProductResponse> getProductByStatusSale() {
//        return mainPageService.getProductByStatusSale();
//    }
//
//    @GetMapping("/recommend")
//    List<ProductResponse> getProductByStatusRecommend() {
//        return mainPageService.getProductByStatusRecommend();
    @GetMapping("/byStatus")
    List<ProductResponse> getAllMainPage(){
        return mainPageService.getALlMainPage();
    }
//    }
}
