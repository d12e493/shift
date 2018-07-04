package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="role_")
public class Role extends BaseEntity {
    @Column(length = 100)
    private String name;
}
