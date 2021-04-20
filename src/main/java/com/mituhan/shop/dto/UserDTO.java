package com.mituhan.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserDTO extends AbstractDTO<UserDTO>{
    private String username;
    private String password;
    private String fullName;
    private String avatar;
    private String email;
    private String mobile;
    private Integer vendor;
    private Integer status;
    private Date lastLogin;
    private List<RoleDTO> roleList = new ArrayList<>();
}
