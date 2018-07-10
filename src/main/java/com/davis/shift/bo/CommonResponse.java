package com.davis.shift.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CommonResponse<T> {
    private List<T> content;
    private T object;
    private Boolean actionStatus;

    public CommonResponse setContent(List list){
        this.content = list;
        return this;
    }

    public CommonResponse actionStatus(boolean flag){
        this.actionStatus = flag;
        return this;
    }

    public CommonResponse setObject(T t){
        this.object = t;
        return this;
    }
}
