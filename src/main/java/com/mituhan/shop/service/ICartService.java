package com.mituhan.shop.service;

import com.mituhan.shop.dto.CartDTO;
import com.mituhan.shop.entity.CartEntity;

import java.util.Optional;

public interface ICartService extends AbstractService<CartDTO>{
    Optional<CartEntity> findById(Long id);
}
