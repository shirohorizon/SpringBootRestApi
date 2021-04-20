package com.mituhan.shop.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class ProductEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<FilterNameEntity> filterNameList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<ProductImageEntity> productImageList = new ArrayList<>();

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "title", length = 75, nullable = false)
    private String title;
    @Column(name = "metatitle", length = 100)
    private String metaTitle;
    @Column(name = "slug", length = 100, nullable = false)
    private String slug;
    @Column(name = "summary", columnDefinition = "TINYTEXT NULL")
    private String summary;
    @Column(name = "sku", length = 100)
    private String sku;
    @Column(name = "price", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float price;
    @Column(name = "discount", columnDefinition = "FLOAT NOT NULL DEFAULT 0")
    private Float discount;
    @Column(name = "quantity", columnDefinition = "SMALLINT(6) NOT NULL DEFAULT 0")
    private Integer quantity;
    @Column(name = "content", columnDefinition = "TEXT NULL")
    private String content;
    @Column(name = "published")
    private Boolean published;
    @Column(name = "publisheddate", updatable = false)
    private Date publishedDate;
}
