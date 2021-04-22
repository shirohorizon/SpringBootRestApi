package com.mituhan.shop.service.impl;

import com.mituhan.shop.converter.OrderConverter;
import com.mituhan.shop.dto.OrderDTO;
import com.mituhan.shop.entity.OrderEntity;
import com.mituhan.shop.repository.OrderItemRepository;
import com.mituhan.shop.repository.OrderRepository;
import com.mituhan.shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderDTO save(OrderDTO objectDTO) {
        OrderEntity orderEntity = new OrderEntity();
        if(objectDTO.getId() != null){
            OrderEntity oldOrder = orderRepository.getOne(objectDTO.getId());
        }else {

        }
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            orderRepository.deleteById(id);
        }

    }

    @Override
    public int totalItem() {
        return (int) orderRepository.count();
    }

    @Override
    public Optional<OrderEntity> findById(Long id) {
        return orderRepository.findById(id);
    }
}
