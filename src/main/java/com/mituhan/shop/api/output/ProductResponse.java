package com.mituhan.shop.api.output;

import com.mituhan.shop.api.input.ProductRequest;
import com.mituhan.shop.entity.ProductEntity;
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
public class ProductResponse {
    private int page;
    private int total_page;
    private List<ProductRequest> products = new ArrayList<>();
}
