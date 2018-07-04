package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table
public class Organize extends BaseEntity {
    @Column(length = 250)
    private String name;

    @Column(length = 32)
    private String organizeId;
}
