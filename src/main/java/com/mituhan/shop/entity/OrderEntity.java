package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "status",nullable = false, columnDefinition = "SMALLINT(6) NOT NULL DEFAULT 0")
    private Integer status;
    @Column(name = "subtotal", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float subTotal;
    @Column(name = "tax", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float tax;
    @Column(name = "shipping", columnDefinition = "TINYINT(1) NOT NULL DEFAULT 0")
    private Integer shipping;
    @Column(name = "total", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float total;
    @Column(name = "discount")
    private Float discount;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "adress")
    private String adress;
}
