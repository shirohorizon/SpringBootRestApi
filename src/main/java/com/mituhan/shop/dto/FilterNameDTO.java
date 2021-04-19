package com.mituhan.shop.dto;

import com.mituhan.shop.entity.FilterNameEntity;
import lombok.Data;

import java.util.List;

@Data
public class FilterNameDTO extends AbstractDTO<FilterNameEntity> {
    private String filterName;
    private List<String> filterValue;
}
