package com.mituhan.shop.repository;

import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>, JpaRepository<ProductEntity, Long>,
        PagingAndSortingRepository<ProductEntity, Long> {
    ProductEntity findProductEntityById(Long id);

    Page<ProductEntity> findAllByPublished(Boolean published, Pageable pageable);
    Page<ProductEntity> findAllByTitleContainingAndPublished(String title,Boolean published, Pageable pageable);
    Page<ProductEntity> findAllByCategoriesAndPublished(CategoryEntity category, Boolean published, Pageable pageable);
    Page<ProductEntity> findAllByCategoriesAndPublishedAndTitleContaining(String title,CategoryEntity category, Boolean published, Pageable pageable);
}
