package com.mituhan.shop.service;

import com.mituhan.shop.dto.CartDTO;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends AbstractService<ProductDTO>{
//    ProductDTO save(ProductDTO productDTO);
//    ProductDTO update(ProductDTO productDTO);
//    void delete(Long[] ids);
    Optional<ProductEntity> findById(Long id);
    List<ProductDTO> findAll(String title,CategoryEntity category, Boolean published, Pageable pageable);
//    int totalItem();
}
