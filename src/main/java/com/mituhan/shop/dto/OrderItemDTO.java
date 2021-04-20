package com.mituhan.shop.dto;

import lombok.Data;


@Data
public class OrderItemDTO extends AbstractDTO<OrderItemDTO>{
    private Long productId;
    private Long orderId;
    private String sku;
    private Float price;
    private Float discount;
    private Integer quantity;
}
