package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "filter_name")
public class FilterNameEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "filterName", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<FilterValueEntity> filterValueList = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;
}
