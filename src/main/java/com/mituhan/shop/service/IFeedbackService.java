package com.mituhan.shop.service;

import com.mituhan.shop.dto.FeedbackDTO;
import com.mituhan.shop.entity.FeedbackEntity;

import java.util.Optional;

public interface IFeedbackService extends BaseService<FeedbackDTO> {
    Optional<FeedbackEntity> findById(Long id);
}
