package com.davis.shift.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtils {
    public static <S,T> List<T> copy(List<S> sourceList , Class<T> targetClass){

        List<T> targetList = new ArrayList<T>();

        try{

            if(!CollectionUtils.isEmpty(sourceList)){
                for(int i=0;i<sourceList.size();i++){
                    T t = targetClass.newInstance();
                    S s = sourceList.get(i);
                    BeanUtils.copyProperties(s,t);
                    targetList.add(t);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return targetList;
    }
}
