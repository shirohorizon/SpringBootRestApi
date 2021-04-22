package com.mituhan.shop.service.impl;

import com.mituhan.shop.converter.CategoryConverter;
import com.mituhan.shop.dto.CategoryDTO;
import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.CategoryRepository;
import com.mituhan.shop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CategoryDTO save(CategoryDTO objectDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if(objectDTO.getId() != null){
            CategoryEntity oldCategory = categoryRepository.getOne(objectDTO.getId());
        }else {

        }
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            categoryRepository.deleteById(id);
        }

    }

    @Override
    public int totalItem() {
        return (int) categoryRepository.count();
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
