package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class UserEntity extends BaseEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles = new ArrayList<>();

    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "vendor", length = 1, columnDefinition = "TINYINT(1) NOT NULL DEFAULT 0")
    private Integer vendor;
    @Column(name = "status", length = 1, columnDefinition = "TINYINT(1) NOT NULL DEFAULT 1")
    private Integer status;
    @Column(name = "lastlogin")
    private Date lastLogin;
}
