package com.mituhan.shop.service;

import com.mituhan.shop.api.input.ProductRequest;
import com.mituhan.shop.api.output.ProductResponse;
import com.mituhan.shop.dto.FilterNameDTO;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.FilterNameEntity;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends AbstractService<ProductDTO>{
    ProductResponse findById(Long id);
    List<ProductDTO> findAll();
    ProductResponse save(ProductRequest request);
}
