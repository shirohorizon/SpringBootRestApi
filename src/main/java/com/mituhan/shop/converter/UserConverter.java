package com.mituhan.shop.converter;

import com.mituhan.shop.dto.UserDTO;
import com.mituhan.shop.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setAvatar(dto.getAvatar());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setMobile(dto.getMobile());
        entity.setStatus(dto.getStatus());
        entity.setVendor(dto.getVendor());
        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setAvatar(entity.getAvatar());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setMobile(entity.getMobile());
        dto.setStatus(entity.getStatus());
        dto.setVendor(entity.getVendor());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public UserEntity toEntity(UserDTO dto, UserEntity entity){
        entity.setAvatar(dto.getAvatar());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setMobile(dto.getMobile());
        entity.setStatus(dto.getStatus());
        entity.setVendor(dto.getVendor());
        return entity;
    }
}
