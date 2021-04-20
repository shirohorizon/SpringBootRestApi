package com.mituhan.shop.dto;

import lombok.Data;

@Data
public class CartItemDTO extends AbstractDTO<CartItemDTO>{
    private Long productId;
    private Long cartId;
    private String sku;
    private Float price;
    private Float discount;
    private Integer quantity;
    private Integer active;
}
