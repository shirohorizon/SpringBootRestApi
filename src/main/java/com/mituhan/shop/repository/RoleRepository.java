package com.mituhan.shop.repository;

import com.mituhan.shop.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>,
        PagingAndSortingRepository<RoleEntity, Long> {
}
