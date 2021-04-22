package com.mituhan.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilterNameDTO {
    private String filterName;
    private List<String> filterValue = new ArrayList<>();
}
