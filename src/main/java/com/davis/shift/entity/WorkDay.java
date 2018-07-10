package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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

    /*
    是否要上班，１要上班 ０放假
     */
    private boolean work = false;

    @Column(name = "dt")
    private LocalDate dt;
}
