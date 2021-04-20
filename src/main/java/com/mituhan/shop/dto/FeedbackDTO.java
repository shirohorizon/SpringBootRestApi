package com.mituhan.shop.dto;

import lombok.Data;


@Data
public class FeedbackDTO extends AbstractDTO<FeedbackDTO>{
    private String fullName;
    private String mobile;
    private String content;
}
