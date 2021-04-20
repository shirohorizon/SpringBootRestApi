package com.mituhan.shop.repository;

import com.mituhan.shop.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long>,
        PagingAndSortingRepository<CartItemEntity, Long> {
}
