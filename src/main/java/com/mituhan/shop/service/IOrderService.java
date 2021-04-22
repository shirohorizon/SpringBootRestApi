package com.mituhan.shop.service;

import com.mituhan.shop.dto.OrderDTO;
import com.mituhan.shop.entity.OrderEntity;

import java.util.Optional;

public interface IOrderService extends BaseService<OrderDTO> {
    Optional<OrderEntity> findById(Long id);
}
