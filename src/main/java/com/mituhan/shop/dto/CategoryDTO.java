package com.mituhan.shop.dto;

import lombok.Data;

@Data
public class CategoryDTO extends BaseDTO<CategoryDTO> {
    private Long parentId;
    private Long[] childId;
    private String title;
    private String metaTitle;
    private String content;
}
