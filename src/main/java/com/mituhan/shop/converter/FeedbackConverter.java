package com.mituhan.shop.converter;

import com.mituhan.shop.dto.FeedbackDTO;
import com.mituhan.shop.entity.FeedbackEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedbackConverter {

    public FeedbackEntity toEntity(FeedbackDTO dto){
        FeedbackEntity entity = new FeedbackEntity();
        entity.setContent(dto.getContent());
        entity.setFullName(dto.getFullName());
        entity.setMobile(dto.getMobile());
        return entity;
    }

    public FeedbackDTO toDTO(FeedbackEntity entity){
        FeedbackDTO dto = new FeedbackDTO();
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setContent(entity.getContent());
        dto.setFullName(entity.getFullName());
        dto.setMobile(entity.getMobile());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public FeedbackEntity toEntity(FeedbackDTO dto, FeedbackEntity entity){
        entity.setContent(dto.getContent());
        entity.setFullName(dto.getFullName());
        entity.setMobile(dto.getMobile());
        return entity;
    }
}
