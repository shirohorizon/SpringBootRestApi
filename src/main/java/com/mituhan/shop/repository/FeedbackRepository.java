package com.mituhan.shop.repository;

import com.mituhan.shop.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long>,
        PagingAndSortingRepository<FeedbackEntity, Long> {
}
