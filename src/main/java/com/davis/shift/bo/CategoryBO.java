package com.davis.shift.bo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
public class CategoryBO {
    private String id;

    private String name;

    private LocalTime startAt;

    private LocalTime endAt;

}
