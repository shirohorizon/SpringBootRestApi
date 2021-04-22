package com.mituhan.shop.api.input;

import com.mituhan.shop.dto.FilterNameDTO;
import com.mituhan.shop.dto.ProductDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductRequest {
    private ProductDTO product;
    private List<FilterNameDTO> filters = new ArrayList<>();
    private List<String> categoryTitles = new ArrayList<>();
}
