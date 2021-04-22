package com.mituhan.shop.service;

import com.mituhan.shop.dto.UserDTO;
import com.mituhan.shop.entity.UserEntity;

import java.util.Optional;

public interface IUserService extends BaseService<UserDTO> {
    Optional<UserEntity> findById(Long id);
    Boolean isUserExist(UserDTO userDTO);
}
