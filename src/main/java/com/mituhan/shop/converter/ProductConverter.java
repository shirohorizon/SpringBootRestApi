package com.mituhan.shop.converter;

import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductEntity toEntity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setUserId(dto.getUserId());
        entity.setTitle(dto.getTitle());
        entity.setMetaTitle(dto.getMetaTitle());
        entity.setSlug(dto.getSlug());
        entity.setSummary(dto.getSummary());
        entity.setSku(dto.getSku());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setQuantity(dto.getQuantity());
        entity.setContent(dto.getContent());
        return entity;
    }

    public ProductDTO toDTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setUserId(entity.getUserId());
        dto.setTitle(entity.getTitle());
        dto.setMetaTitle(entity.getMetaTitle());
        dto.setSlug(entity.getSlug());
        dto.setSummary(entity.getSummary());
        dto.setSku(entity.getSku());
        dto.setPrice(entity.getPrice());
        dto.setDiscount(entity.getDiscount());
        dto.setQuantity(entity.getQuantity());
        dto.setContent(entity.getContent());
        return dto;
    }

    public ProductEntity toEntity(ProductDTO dto, ProductEntity entity){
        entity.setUserId(dto.getUserId());
        entity.setTitle(dto.getTitle());
        entity.setMetaTitle(dto.getMetaTitle());
        entity.setSlug(dto.getSlug());
        entity.setSummary(dto.getSummary());
        entity.setSku(dto.getSku());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setQuantity(dto.getQuantity());
        entity.setContent(dto.getContent());
        return entity;
    }
}
