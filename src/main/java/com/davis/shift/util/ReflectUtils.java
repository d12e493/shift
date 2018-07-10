package com.davis.shift.util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class ReflectUtils {
    public static void setField(Object obj,String fieldName,Object value){
        Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, obj, value);
    }
}
