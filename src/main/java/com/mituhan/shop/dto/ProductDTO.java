package com.mituhan.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends BaseDTO<ProductDTO> {
    private Long userId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private String sku;
    private Float price;
    private Float discount;
    private Integer quantity;
    private String content;
}
