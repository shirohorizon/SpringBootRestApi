package com.mituhan.shop.converter;

import com.mituhan.shop.dto.FilterNameDTO;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.FilterNameEntity;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
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
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
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


    public List<FilterNameDTO> toDTO(List<FilterNameEntity> entity){
        List<FilterNameDTO> dto = new ArrayList<>();
        entity.forEach(e->{
            FilterNameDTO filterNameDTO = new FilterNameDTO();
            filterNameDTO.setFilterName(e.getName());
            e.getFilterValueList().forEach(fv->{
                filterNameDTO.getFilterValue().add(fv.getValue());
            });
            dto.add(filterNameDTO);
        });
        return dto;
    }

    public List<String> toList(List<CategoryEntity> entities){
        List<String> list = new ArrayList<>();
        entities.forEach(c->{
            list.add(c.getTitle());
        });
        return list;
    }
}
