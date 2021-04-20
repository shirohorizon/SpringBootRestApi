package com.mituhan.shop.service;

import com.mituhan.shop.dto.CategoryDTO;
import com.mituhan.shop.entity.CategoryEntity;

import java.util.Optional;

public interface ICategoryService extends AbstractService<CategoryDTO>{
    Optional<CategoryEntity> findById(Long id);
}
