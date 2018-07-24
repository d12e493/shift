package com.davis.shift.bo.work;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class WorkYear {
    private Integer year;
    private List<WorkMonth> monthList = new ArrayList<>();
    private int dayCount = 0;

    public int getDayCount(){
        monthList.forEach(m->{
            dayCount+=m.getDayList().size();
        });
        return this.dayCount;
    }
}
