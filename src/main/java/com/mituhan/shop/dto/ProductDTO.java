package com.mituhan.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
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
    private List<String> categoryTitle;
    private List<FilterNameDTO> filterNameDTOList;
}
