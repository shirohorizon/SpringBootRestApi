package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "product_image")
public class ProductImageEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "image", nullable = false)
    private String image;
}
