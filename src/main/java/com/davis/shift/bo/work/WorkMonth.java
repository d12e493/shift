package com.davis.shift.bo.work;

import com.davis.shift.bo.WorkDayBO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class WorkMonth {
    private Integer month;
    private List<WorkDayBO> dayList = new ArrayList<>();
    private int dayCount = 0;

    public int getDayCount(){
        this.dayCount = dayList.size();
        return this.dayCount;
    }
}
