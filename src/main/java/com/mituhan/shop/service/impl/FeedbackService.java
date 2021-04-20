package com.mituhan.shop.service.impl;

import com.mituhan.shop.dto.FeedbackDTO;
import com.mituhan.shop.entity.FeedbackEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.FeedbackRepository;
import com.mituhan.shop.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackDTO save(FeedbackDTO objectDTO) {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        if(objectDTO.getId() != null){
            FeedbackEntity oldFeedback= feedbackRepository.getOne(objectDTO.getId());
        }else {

        }
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            feedbackRepository.deleteById(id);
        }

    }

    @Override
    public int totalItem() {
        return (int) feedbackRepository.count();
    }

    @Override
    public Optional<FeedbackEntity> findById(Long id) {
        return feedbackRepository.findById(id);
    }
}
