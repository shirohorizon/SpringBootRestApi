package com.mituhan.shop.service.impl;

import com.mituhan.shop.api.input.ProductRequest;
import com.mituhan.shop.api.output.ProductResponse;
import com.mituhan.shop.converter.ProductConverter;
import com.mituhan.shop.dto.FilterNameDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public void delete(Long[] ids) {
        for (Long id: ids){
            productRepository.deleteById(id);
        }
    }

  @Override
  public ProductResponse findById(Long id) {
    ProductResponse response = new ProductResponse();
    ProductEntity entity = productRepository.findById(id).get();
    ProductRequest request = new ProductRequest();
    request.getFilters().addAll(productConverter.toDTO(entity.getFilterNameList()));
    request.setProduct(productConverter.toDTO(entity));
    request.getCategoryTitles().addAll(productConverter.toList(entity.getCategories()));
    response.getProducts().add(request);
    return response;
  }


  @Override
  public ProductResponse findAll(String title, Pageable pageable) {
    ProductResponse response = new ProductResponse();
    Page<ProductEntity> page = productRepository.findAllByTitleContaining(title, pageable);
    response.setTotal_page(page.getTotalPages());
    response.setPage(page.getNumber()+1);
    List<ProductEntity> entities = page.getContent();
    entities.forEach(e->{
      ProductRequest request = new ProductRequest();
      request.setProduct(productConverter.toDTO(e));
      request.setFilters(productConverter.toDTO(e.getFilterNameList()));
      request.setCategoryTitles(productConverter.toList(e.getCategories()));
      response.getProducts().add(request);
    });
    return response;
  }

  @Override
  @Transactional
  public ProductResponse save(ProductRequest request) {
    ProductResponse response = new ProductResponse();
    ProductEntity entity = new ProductEntity();
    ProductEntity oldEntity = new ProductEntity();
    //check product Id -> post or put
    if (request.getProduct().getId() != null){
      //put
      oldEntity = productRepository.findById(request.getProduct().getId()).get();
      oldEntity.getFilterNameList().removeAll(oldEntity.getFilterNameList());
//      productRepository.save(oldEntity);
//      oldEntity = productRepository.findById(request.getProduct().getId()).get();
      entity = productConverter.toEntity(request.getProduct(), oldEntity);
    }else {
      //post
      entity = productConverter.toEntity(request.getProduct());
    }
    //add category to product
    List<CategoryEntity> newCategory = new ArrayList<>();
    request.getCategoryTitles().forEach(c->{
      //get list category
      newCategory.add(categoryRepository.findOneByTitle(c));
    });
    entity.getCategories().removeAll(newCategory);
    entity.getCategories().addAll(newCategory);

    //add filter to product
    //delete old filter by entity
    List<FilterNameEntity> fnEntities = new ArrayList<>();
    ProductEntity finalEntity = entity;
    request.getFilters().forEach(fn->{
      FilterNameEntity fnEntity = new FilterNameEntity();
      fnEntity.setName(fn.getFilterName());
      fnEntity.setProduct(finalEntity);
      if (finalEntity.getId() != null){
        //put
        List<FilterValueEntity> fvEntities = new ArrayList<>();
        fn.getFilterValue().forEach(fv->{
          FilterValueEntity fvEntity = new FilterValueEntity();
          fvEntity.setValue(fv);
          fvEntity.setFilterName(fnEntity);
          fvEntities.add(fvEntity);
        });
        fnEntity.setFilterValueList(fvEntities);
        finalEntity.getFilterNameList().add(fnEntity);
        filterNameRepository.save(fnEntity);
        fnEntities.add(fnEntity);
      }else {
        //post
        List<FilterValueEntity> fvEntities = new ArrayList<>();
        fn.getFilterValue().forEach(fv->{
          FilterValueEntity fvEntity = new FilterValueEntity();
          fvEntity.setValue(fv);
          fvEntity.setFilterName(fnEntity);
          fvEntities.add(fvEntity);
        });
        fnEntity.setFilterValueList(fvEntities);
        fnEntities.add(fnEntity);
      }
    });
    if (finalEntity.getId() == null){
      finalEntity.setFilterNameList(fnEntities);
    }
    entity = productRepository.save(finalEntity);
    ProductRequest request1 = new ProductRequest();
    request1.setProduct(productConverter.toDTO(entity));
    request1.getFilters().addAll(productConverter.toDTO(entity.getFilterNameList()));
    request1.getCategoryTitles().addAll(productConverter.toList(entity.getCategories()));
    response.getProducts().add(request1);
    return response;
  }


  @Override
  public int totalItem() {
    return (int) productRepository.count();
  }

  @Override
  public ProductDTO save(ProductDTO objectDTO) {
    return null;
  }
}
