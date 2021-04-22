package com.mituhan.shop.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO extends BaseDTO<UserDTO> {
    private String username;
    private String password;
    private String fullName;
    private String avatar;
    private String email;
    private String mobile;
    private Integer vendor;
    private Integer status;
    private Date lastLogin;
    private List<String> roleName;
}
