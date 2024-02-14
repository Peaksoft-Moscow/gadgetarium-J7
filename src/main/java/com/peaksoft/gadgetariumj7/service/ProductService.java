package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.exception.NotFoundExcepption;
import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.BrandRequest;
import com.peaksoft.gadgetariumj7.model.dto.BrandResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductRequest;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Brand;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.SubCategory;
import com.peaksoft.gadgetariumj7.repository.BrandRepository;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.mapToEntity(request);
        SubCategory subCategory = subCategoryRepository.findById(request.getSubCategoryId()).orElseThrow(
                () -> new NotFoundExcepption("Not found by this Id"));
        Brand brandOfProduct = brandRepository.findById(request.getBrandId()).orElseThrow(
                () -> new NotFoundExcepption("Not found by this Id"));
        product.setSubCategory(subCategory);
        product.setBrandOfProduct(brandOfProduct);
        productRepository.save(product);
        log.info("created a new product");
        return productMapper.mapToResponse(product);
    }

    public BrandResponse createBrand(BrandRequest request) {
        Brand brand = productMapper.mapToEntityBrand(request);
        brandRepository.save(brand);
        return productMapper.mapToResponseBrand(brand);
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productResponses.add(productMapper.mapToResponse(product));
        }
        return productResponses;
    }

    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepption("There is no product with this id! <<" + id + ">>")
        );
        log.info("Not found this is product");
        return productMapper.mapToResponse(product);
    }

    public ProductResponse updateProductById(Long id, ProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepption("There is no product with this id! <<" + id + ">>")
        );
        product.setProductName(request.getName());
        product.setOperationSystem(request.getOperationSystem());
        product.setDiscount(request.getDiscount());
        product.setMemory(request.getMemory());
        product.setPrice(request.getPrice());
        product.setGuarantee(request.getGuarantee());
        product.setOperationMemory(request.getOperationMemory());
        product.setColor(request.getColor());
        product.setMemory(request.getMemory());
        product.setCreateDate(request.getCreateDate());
        productRepository.save(product);
        return productMapper.mapToResponse(product);
    }

    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepption("There is no product with this id! <<" + id + ">>")
        );
        productRepository.deleteById(product.getId());
        log.info("Deleted");
    }

    public List<ProductResponse> getFilteredProduct(
            List<String> brands,
            List<Integer> prices,
            List<String> colors,
            List<String> memories,
            List<String> operationMemory) {
        List<Product> attribute = productRepository.productFilter(brands, prices, colors, memories, operationMemory);
        return attribute.stream().map(productMapper::mapToResponse).toList();
    }
}
