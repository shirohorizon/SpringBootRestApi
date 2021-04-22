package com.mituhan.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO extends BaseDTO<CartDTO> {
    private Long userId;
    private Integer status;
    private String fullName;
    private String mobile;
    private String email;
    private String adress;
    private List<CartItemDTO> cartItemList = new ArrayList<>();
}
