package com.davis.shift.controller;

import com.davis.shift.bo.CommonResponse;
import org.springframework.web.bind.annotation.*;

public abstract class CommonController<T> {

    @PostMapping
    abstract CommonResponse create(T obj);

    @GetMapping("/{id}")
    abstract CommonResponse get(String id);

    @GetMapping
    abstract CommonResponse list();

    @PutMapping
    abstract CommonResponse update(T obj);

    @PatchMapping
    abstract CommonResponse modify(T obj);

    @DeleteMapping("/{id}")
    abstract CommonResponse delete(String id);
}
