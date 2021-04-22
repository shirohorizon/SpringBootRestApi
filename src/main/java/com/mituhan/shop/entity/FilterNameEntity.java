package com.mituhan.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "filter_name")
public class FilterNameEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductEntity product;

    @OneToMany(targetEntity = FilterValueEntity.class, mappedBy = "filterName", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<FilterValueEntity> filterValueList = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;
}
