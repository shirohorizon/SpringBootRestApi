package com.mituhan.shop.repository;

import com.mituhan.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>,
        PagingAndSortingRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
