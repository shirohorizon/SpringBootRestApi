package com.mituhan.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "feedback")
public class FeedbackEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "fullname")
    private String fullName;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "content", columnDefinition = "TEXT NULL")
    private String content;
}
