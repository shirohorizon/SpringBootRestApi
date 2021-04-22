package com.mituhan.shop.converter;

import com.mituhan.shop.dto.ContactDTO;
import com.mituhan.shop.entity.ContactEntity;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter {

    public ContactEntity toEntity(ContactDTO dto){
        ContactEntity entity = new ContactEntity();
        entity.setAdress(dto.getAdress());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
        entity.setContent(dto.getContent());
        entity.setMobile(dto.getMobile());
        entity.setGender(dto.getGender());
        return entity;
    }

    public ContactDTO toDTO(ContactEntity entity){
        ContactDTO dto = new ContactDTO();
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setAdress(entity.getAdress());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());
        dto.setContent(entity.getContent());
        dto.setMobile(entity.getMobile());
        dto.setGender(entity.getGender());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public ContactEntity toEntity(ContactDTO dto, ContactEntity entity){
        entity.setAdress(dto.getAdress());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
        entity.setContent(dto.getContent());
        entity.setMobile(dto.getMobile());
        entity.setGender(dto.getGender());
        return entity;
    }
}
