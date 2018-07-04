package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Setter
@Getter
@Entity
@Table
public class WorkDay extends BaseEntity{
    @Column(length = 100,nullable = false)
    private String name;

    private int year;
    private int month;
    private int day;

    @Column(name = "dt")
    @Temporal(TemporalType.DATE)
    private Calendar dt;
}
