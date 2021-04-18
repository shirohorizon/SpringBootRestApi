package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class CategoryEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new ArrayList<>();

    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "title", length = 75, nullable = false)
    private String title;
    @Column(name = "metatitle", length = 100)
    private String metaTitle;
    @Column(name = "content", columnDefinition = "TEXT NULL")
    private String content;
}
