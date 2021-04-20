package com.mituhan.shop.api.output;

import com.mituhan.shop.dto.ProductDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductOutput {
    private int page;
    private int totalPage;
    private List<ProductDTO> products = new ArrayList<>();
}
