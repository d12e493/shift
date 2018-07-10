package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Calendar;

@Setter
@Getter
@Entity
@Table
public class Category extends BaseEntity {

    @Column(length = 100,nullable = false)
    private String name;

    private int total_hour;
    private int total_minute;

    @Column(name = "start_at")
    private LocalTime startAt;

    @Column(name = "end_at")
    private LocalTime endAt;
}
