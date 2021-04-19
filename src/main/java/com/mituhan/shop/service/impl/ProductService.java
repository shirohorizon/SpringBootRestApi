package com.mituhan.shop.service.impl;

import com.mituhan.shop.converter.ProductConverter;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.FilterNameEntity;
import com.mituhan.shop.entity.FilterValueEntity;
import com.mituhan.shop.entity.ProductEntity;
import com.mituhan.shop.repository.CategoryRepository;
import com.mituhan.shop.repository.FilterNameRepository;
import com.mituhan.shop.repository.FilterValueRepository;
import com.mituhan.shop.repository.ProductRepository;
import com.mituhan.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private FilterNameRepository filterNameRepository;

    @Autowired
    private FilterValueRepository filterValueRepository;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = productConverter.toEntity(productDTO);
        ProductEntity finalProductEntity = productEntity;
        productDTO.getCategoryTitle().forEach(c->{
            CategoryEntity categoryEntity = categoryRepository.findOneByTitle(c);
            finalProductEntity.getCategories().add(categoryEntity);
        });
        productEntity = productRepository.save(finalProductEntity);
        ProductEntity finalProductEntity1 = productEntity;
        productDTO.getFilterNameDTOList().forEach(fn->{
            FilterNameEntity filterNameEntity = new FilterNameEntity();
            filterNameEntity.setName(fn.getFilterName());
            filterNameEntity.setProduct(finalProductEntity1);
            fn.getFilterValue().forEach(fv->{
                FilterValueEntity filterValueEntity = new FilterValueEntity();
                filterValueEntity.setValue(fv);
                filterValueEntity.setFilterName(filterNameEntity);
                filterValueRepository.save(filterValueEntity);
            });
        });
        return productConverter.toDTO(productEntity);
    }
}