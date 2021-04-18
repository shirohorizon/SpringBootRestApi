package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "contact")
public class ContactEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "adress")
    private String adress;
    @Column(name = "gender", length = 1, columnDefinition = "TINYINT(1) NOT NULL DEFAULT 1")
    private Integer gender;
    @Column(name = "age", columnDefinition = "SMALLINT(6) NULL")
    private Integer age;
    @Column(name = "content", columnDefinition = "TEXT NULL")
    private String content;
}
