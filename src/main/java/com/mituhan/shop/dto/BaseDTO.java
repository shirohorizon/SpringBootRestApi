package com.mituhan.shop.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BaseDTO<T> {
    private Long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private String modifiedDate;
    private List<T> listResult = new ArrayList<T>();
    private Page<T> pageResult;
}
