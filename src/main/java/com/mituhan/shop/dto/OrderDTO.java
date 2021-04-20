package com.mituhan.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO extends AbstractDTO<OrderDTO>{
    private Long userId;
    private Integer status;
    private Float subTotal;
    private Float tax;
    private Integer shipping;
    private Float total;
    private Float discount;
    private String fullName;
    private String mobile;
    private String email;
    private String adress;
    private List<OrderItemDTO> orderItemList = new ArrayList<>();
}
