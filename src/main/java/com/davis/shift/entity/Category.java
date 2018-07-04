package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Setter
@Getter
@Entity
@Table
public class Category extends BaseEntity {

    @Column(length = 100,nullable = false)
    private String name;

    private int hour;
    private int minute;

    @Column(name = "start_at")
    private String startAt;

    @Column(name = "end_at")
    private String endAt;
}
