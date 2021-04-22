package com.mituhan.shop.converter;

import com.mituhan.shop.dto.OrderDTO;
import com.mituhan.shop.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderEntity toEntity(OrderDTO dto){
        OrderEntity entity = new OrderEntity();
        entity.setAdress(dto.getAdress());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setDiscount(dto.getDiscount());
        entity.setShipping(dto.getShipping());
        entity.setMobile(dto.getMobile());
        entity.setStatus(dto.getStatus());
        entity.setTax(dto.getTax());
        entity.setSubTotal(dto.getSubTotal());
        entity.setTotal(dto.getTotal());
        entity.setUserId(dto.getUserId());
        return entity;
    }

    public OrderDTO toDTO(OrderEntity entity){
        OrderDTO dto = new OrderDTO();
        if (entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setAdress(entity.getAdress());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setDiscount(entity.getDiscount());
        dto.setShipping(entity.getShipping());
        dto.setMobile(entity.getMobile());
        dto.setStatus(entity.getStatus());
        dto.setTax(entity.getTax());
        dto.setSubTotal(entity.getSubTotal());
        dto.setTotal(entity.getTotal());
        dto.setUserId(entity.getUserId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifieddate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public OrderEntity toEntity(OrderDTO dto, OrderEntity entity){
        entity.setAdress(dto.getAdress());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setDiscount(dto.getDiscount());
        entity.setShipping(dto.getShipping());
        entity.setMobile(dto.getMobile());
        entity.setStatus(dto.getStatus());
        entity.setTax(dto.getTax());
        entity.setSubTotal(dto.getSubTotal());
        entity.setTotal(dto.getTotal());
        entity.setUserId(dto.getUserId());
        return entity;
    }
}
