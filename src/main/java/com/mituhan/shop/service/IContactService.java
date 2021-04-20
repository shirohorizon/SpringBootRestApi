package com.mituhan.shop.service;

import com.mituhan.shop.dto.ContactDTO;
import com.mituhan.shop.entity.ContactEntity;

import java.util.Optional;

public interface IContactService extends AbstractService<ContactDTO>{
    Optional<ContactEntity> findById(Long id);
}
