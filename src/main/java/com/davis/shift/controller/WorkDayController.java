package com.davis.shift.controller;

import com.davis.shift.bo.CommonResponse;
import com.davis.shift.bo.WorkDayBO;
import com.davis.shift.dao.WorkDayRepository;
import com.davis.shift.entity.WorkDay;
import com.davis.shift.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/works")
public class WorkDayController extends CommonController<WorkDayBO> {

    @Autowired
    private WorkDayRepository workDayRepository;

    @Override
    CommonResponse create(@RequestBody WorkDayBO obj) {

        WorkDay w = new WorkDay();
        w.setName(obj.getName());
        w.setWork(obj.isWork());
        // dt 處理
        DateTimeUtils.parseToObjectFromDateString(obj.getDt(),w);

        workDayRepository.save(w);

        return new CommonResponse().actionStatus(true);
    }

    @Override
    CommonResponse get(@PathVariable String id) {
        return null;
    }

    @Override
    CommonResponse list() {
        return null;
    }

    @Override
    CommonResponse update(@RequestBody WorkDayBO obj) {
        return null;
    }

    @Override
    CommonResponse modify(@RequestBody WorkDayBO obj) {
        return null;
    }

    @Override
    CommonResponse delete(@PathVariable String id) {
        return null;
    }

    @GetMapping(path = "/query/{start}~{end}")
    public CommonResponse getWorkAndHoliday(@PathVariable String start,@PathVariable String end){

        LocalDate startDate = DateTimeUtils.toDate(start);

        LocalDate endDate = DateTimeUtils.toDate(end);

        // db 有額外設定的日期
        List<WorkDay> dbWorkDayList = workDayRepository.findByDtBetween(startDate,endDate);

        Map<String,WorkDay> dbWorkDayMap = dbWorkDayList.stream()
                .collect(Collectors.toMap(x->x.getDt().toString(),Function.identity()));

        // 取得這段期間的全部日期
        List workBoList = new ArrayList<WorkDayBO>();

        LocalDate tempDate = startDate;

        while(!tempDate.isAfter(endDate)){

            WorkDayBO bo = new WorkDayBO();
            bo.setDt(tempDate);
            bo.setWork(true);

            String tempDateKey = DateTimeUtils.fromDate(tempDate);

            // 預設設定好的 補班 / 放假
            if(dbWorkDayMap.containsKey(tempDateKey)){
                WorkDay workFromMap = dbWorkDayMap.get(tempDateKey);
                bo.setName(workFromMap.getName());
                bo.setWork(workFromMap.isWork());
            }
            // 一般 放假 / 上班規則，週休二日
            else{
                if(tempDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || tempDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    bo.setWork(false);
                }
            }

            workBoList.add(bo);
            tempDate = tempDate.plusDays(1);
        }

        return new CommonResponse().setContent(workBoList);
    }
}
