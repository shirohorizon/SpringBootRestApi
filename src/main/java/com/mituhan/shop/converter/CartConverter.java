package com.mituhan.shop.converter;

import com.mituhan.shop.dto.CartDTO;
import com.mituhan.shop.entity.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public CartEntity toEntity(CartDTO dto){
        CartEntity entity = new CartEntity();
        entity.setAdress(dto.getAdress());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setUserId(dto.getUserId());
        entity.setMobile(dto.getMobile());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public CartDTO toDTO(CartEntity entity){
        CartDTO dto = new CartDTO();
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setAdress(entity.getAdress());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setMobile(entity.getMobile());
        dto.setStatus(entity.getStatus());
        dto.setUserId(entity.getUserId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public CartEntity toEntity(CartDTO dto, CartEntity entity){
        entity.setAdress(dto.getAdress());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setUserId(dto.getUserId());
        entity.setMobile(dto.getMobile());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
