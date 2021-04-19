package com.mituhan.shop.repository;

import com.mituhan.shop.entity.FilterNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterNameRepository extends JpaRepository<FilterNameEntity, Long> {

}
