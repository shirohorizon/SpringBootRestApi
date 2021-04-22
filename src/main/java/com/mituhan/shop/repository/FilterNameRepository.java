package com.mituhan.shop.repository;

import com.mituhan.shop.entity.FilterNameEntity;
import com.mituhan.shop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterNameRepository extends JpaRepository<FilterNameEntity, Long>,
        PagingAndSortingRepository<FilterNameEntity, Long> {
    FilterNameEntity findByName(String name);
}
