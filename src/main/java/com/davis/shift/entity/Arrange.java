package com.davis.shift.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

@Setter
@Getter
@Entity
@Table
@Where(clause="deleted_at is null")
public class Arrange extends BaseEntity implements Serializable{
    @Column(length = 32,nullable = false)
    private String categoryId;

    @Column(length = 32,nullable = false)
    private String regionId;

    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private int month;
    @Column(nullable = false)
    private int day;

    @Column(name = "dt",nullable = false)
    private LocalDate dt;

    @Column(name = "start_at",nullable = false)
    private LocalTime startAt;

    @Column(name = "end_at",nullable = false)
    private LocalTime endAt;

    @Column(name = "duration_minute",nullable = false)
    private int durationMinute;

    @Column(name = "user_id",nullable = false)
    private String userId;
}