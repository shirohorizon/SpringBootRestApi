package com.mituhan.shop.entity;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "createdby", updatable = false)
    private String createdBy;
    @Column(name = "createddate", updatable = false)
    private Date createdDate;

    @Column(name = "modifiedby")
    private String modifiedBy;
    @Column(name = "modifieddate")
    private String modifieddate;
}
