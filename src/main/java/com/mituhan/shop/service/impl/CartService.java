package com.mituhan.shop.service.impl;

import com.mituhan.shop.dto.CartDTO;
import com.mituhan.shop.entity.CartEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.CartItemRepository;
import com.mituhan.shop.repository.CartRepository;
import com.mituhan.shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartDTO save(CartDTO objectDTO) {
        CartEntity cartEntity = new CartEntity();
        if(objectDTO.getId() != null){
            CartEntity oldCart = cartRepository.getOne(objectDTO.getId());
        }else {

        }
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            cartRepository.deleteById(id);
        }
    }

    @Override
    public int totalItem() {
        return (int) cartRepository.count();
    }

    @Override
    public Optional<CartEntity> findById(Long id) {
        return cartRepository.findById(id);
    }
}
