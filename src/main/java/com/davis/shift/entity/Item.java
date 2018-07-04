package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table
@Where(clause="deleted_at is null")
public class Item extends BaseEntity implements Serializable{
    @Column(length = 100,nullable = false)
    private String name;

    @Column
    private String description;

    @Column(length = 32)
    private String organizeId;
}