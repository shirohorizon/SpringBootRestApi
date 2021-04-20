package com.mituhan.shop.repository;

import com.mituhan.shop.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>,
        PagingAndSortingRepository<CartEntity, Long> {
}
