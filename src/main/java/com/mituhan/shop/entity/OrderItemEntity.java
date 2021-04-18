package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "order_item")
public class OrderItemEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @Column(name = "sku", length = 100)
    private String sku;
    @Column(name = "price", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float price;
    @Column(name = "discount", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float discount;
    @Column(name = "quantity", columnDefinition = "SMALLINT(6) NOT NULL DEFAULT 0")
    private Integer quantity;
}
