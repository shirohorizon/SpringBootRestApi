package com.mituhan.shop.api;

import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.dto.UserDTO;
import com.mituhan.shop.entity.ProductEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserAPI {

    public static final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> createProduct(@RequestBody UserDTO model) {
        logger.info("Creating User : {}", model);
        try {
            UserDTO userDTO = userService.save(model);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/users/{userId}")
    public ResponseEntity<UserDTO> editProduct(@PathVariable(name = "userId") Long userId,
                                                  @RequestBody UserDTO model) {
        Optional<UserEntity> userEntity = userService.findById(userId);
        if (userEntity.isPresent()){
            model.setId(userId);
            // Trả về đối tượng sau khi đã edit
            return new ResponseEntity<>(userService.save(model), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] ids) {
        try {
            userService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
