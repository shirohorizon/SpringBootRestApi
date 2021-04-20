package com.mituhan.shop.repository;

import com.mituhan.shop.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long>,
        PagingAndSortingRepository<ContactEntity, Long> {
}
