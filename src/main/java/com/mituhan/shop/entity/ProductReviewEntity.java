package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "product_review")
public class ProductReviewEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "rating", nullable = false, columnDefinition = "SMALLINT(6) NOT NULL DEFAULT 0")
    private Integer rating;
    @Column(name = "content", columnDefinition = "TEXT NULL")
    private String content;
}
