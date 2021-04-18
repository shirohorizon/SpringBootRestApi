package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "filter_value")
public class FilterValueEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "filter_name_id", insertable = false, updatable = false)
    private FilterNameEntity filterName;

    @Column(name = "value", nullable = false)
    private String value;
}
