package com.mituhan.shop.repository;

import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>,
        PagingAndSortingRepository<ProductEntity, Long> {

    Page<ProductEntity> findAllByPublished(Boolean published, Pageable pageable);
    Page<ProductEntity> findAllByTitleContainingAndPublished(String title,Boolean published, Pageable pageable);
    Page<ProductEntity> findAllByCategoriesAndPublished(CategoryEntity category, Boolean published, Pageable pageable);
    Page<ProductEntity> findAllByCategoriesAndPublishedAndTitleContaining(String title,CategoryEntity category, Boolean published, Pageable pageable);
}
