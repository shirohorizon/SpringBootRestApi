package com.mituhan.shop.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.List;

@Data
public class FilterNameDTO {
    private String filterName;
    private List<String> filterValue;
}
