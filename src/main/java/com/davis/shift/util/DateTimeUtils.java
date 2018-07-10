package com.davis.shift.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    public static final DateTimeFormatter HOUR_AND_MINUTE_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static LocalTime toTime(String hourAndMinute){
        return LocalTime.parse(hourAndMinute, HOUR_AND_MINUTE_FORMAT);
    }

    public static LocalDate toDate(String date){
        return LocalDate.parse(date,DATE_FORMATTER);
    }

    public static String fromDate(LocalDate date){
        return date.format(DATE_FORMATTER);
    }

    public static String formatHourAndMinute(LocalTime time){
        return time.format(HOUR_AND_MINUTE_FORMAT);
    }

    public static Calendar toCalendarFromDate(String inputDate){
        try {
            Date date = DATE_FORMAT.parse(inputDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            return cal;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * set dt,year,month,day to object
     *
     * @param dt
     * @param obj
     */
    public static void parseToObjectFromDateString(String dt , Object obj){

        LocalDate date = toDate(dt);

        parseToObjectFromDateString(date,obj);
    }

    public static void parseToObjectFromDateString(LocalDate dt , Object obj){
        ReflectUtils.setField(obj,"dt",dt);
        ReflectUtils.setField(obj,"year",dt.getYear());
        ReflectUtils.setField(obj,"month",dt.getMonthValue());
        ReflectUtils.setField(obj,"day",dt.getDayOfMonth());
    }
}
