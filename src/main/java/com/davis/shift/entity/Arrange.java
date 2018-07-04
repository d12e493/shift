package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Setter
@Getter
@Entity
@Table
@Where(clause="deleted_at is null")
public class Arrange extends BaseEntity implements Serializable{
    @Column(length = 32)
    private String categoryId;

    private int year;
    private int month;
    private int day;

    @Column(name = "dt")
    @Temporal(TemporalType.DATE)
    private Calendar dt;

    @Column(name = "start_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startAt;

    @Column(name = "end_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endAt;
}