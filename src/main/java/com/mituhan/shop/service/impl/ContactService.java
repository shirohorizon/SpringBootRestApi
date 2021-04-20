package com.mituhan.shop.service.impl;

import com.mituhan.shop.dto.ContactDTO;
import com.mituhan.shop.entity.ContactEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.ContactRepository;
import com.mituhan.shop.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactDTO save(ContactDTO objectDTO) {
        ContactEntity contactEntity = new ContactEntity();
        if(objectDTO.getId() != null){
            ContactEntity oldContact = contactRepository.getOne(objectDTO.getId());
        }else {

        }
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            contactRepository.deleteById(id);
        }

    }

    @Override
    public int totalItem() {
        return (int) contactRepository.count();
    }

    @Override
    public Optional<ContactEntity> findById(Long id) {
        return contactRepository.findById(id);
    }
}
