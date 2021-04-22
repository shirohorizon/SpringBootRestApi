package com.mituhan.shop.service;

import com.mituhan.shop.api.input.ProductRequest;
import com.mituhan.shop.api.output.ProductResponse;
import com.mituhan.shop.dto.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService extends BaseService<ProductDTO> {
    ProductResponse findById(Long id);
    ProductResponse findAll(String title, Pageable pageable);
    ProductResponse save(ProductRequest request);
}
