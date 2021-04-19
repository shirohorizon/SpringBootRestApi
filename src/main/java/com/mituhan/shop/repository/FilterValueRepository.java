package com.mituhan.shop.repository;

import com.mituhan.shop.entity.FilterValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterValueRepository extends JpaRepository<FilterValueEntity, Long> {
}
