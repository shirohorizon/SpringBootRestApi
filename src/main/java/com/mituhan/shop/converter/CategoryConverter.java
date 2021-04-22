package com.mituhan.shop.converter;

import com.mituhan.shop.dto.CategoryDTO;
import com.mituhan.shop.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryEntity toEntity(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setMetaTitle(dto.getMetaTitle());
        entity.setParentId(dto.getParentId());
        return entity;
    }

    public CategoryDTO toDTO(CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setMetaTitle(entity.getMetaTitle());
        dto.setParentId(entity.getParentId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity){
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setMetaTitle(dto.getMetaTitle());
        entity.setParentId(dto.getParentId());
        return entity;
    }
}
