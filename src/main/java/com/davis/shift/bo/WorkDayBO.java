package com.davis.shift.bo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class WorkDayBO {
    private String name;
    private boolean work = false;
    private LocalDate dt;
}
