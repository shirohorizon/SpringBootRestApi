package com.mituhan.shop.service;

import com.mituhan.shop.dto.ProductDTO;

public interface IProductService {
    ProductDTO save(ProductDTO productDTO);
//    ProductDTO update(ProductDTO productDTO);
    void delete(Long[] ids);
}
