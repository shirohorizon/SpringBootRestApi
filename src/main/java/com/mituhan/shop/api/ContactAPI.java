package com.mituhan.shop.api;

import com.mituhan.shop.dto.ContactDTO;
import com.mituhan.shop.entity.ContactEntity;
import com.mituhan.shop.service.IContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ContactAPI {

    public static final Logger logger = LoggerFactory.getLogger(ContactAPI.class);

    @Autowired
    private IContactService contactService;

    @PostMapping(value = "/contacts")
    public ResponseEntity<ContactDTO> createProduct(@RequestBody ContactDTO model) {
        logger.info("Creating Contact : {}", model);
        try {
            ContactDTO contactDTO = contactService.save(model);
            return new ResponseEntity<>(contactDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/contacts/{contactId}")
    public ResponseEntity<ContactDTO> editProduct(@PathVariable(name = "contactId") Long contactId,
                                                  @RequestBody ContactDTO model) {
        try {
            Optional<ContactEntity> contactEntity = contactService.findById(contactId);
            if (contactEntity.isPresent()){
                model.setId(contactId);
                // Trả về đối tượng sau khi đã edit
                return new ResponseEntity<>(contactService.save(model), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/contacts")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] ids) {
        try {
            contactService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
