package com.mituhan.shop.dto;

import lombok.Data;

@Data
public class ContactDTO extends BaseDTO<ContactDTO> {
    private String fullName;
    private String mobile;
    private String email;
    private String adress;
    private Integer gender;
    private Integer age;
    private String content;
}
