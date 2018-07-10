package com.davis.shift.controller;

import com.davis.shift.bo.ArrangeBO;
import com.davis.shift.bo.CommonResponse;
import com.davis.shift.dao.ArrangeRepository;
import com.davis.shift.dao.CategoryRepository;
import com.davis.shift.entity.Arrange;
import com.davis.shift.entity.Category;
import com.davis.shift.util.DateTimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/arranges")
public class ArrangeController extends CommonController<ArrangeBO>{

    @Autowired
    private ArrangeRepository arrangeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    CommonResponse create(@RequestBody ArrangeBO obj) {

        Arrange saveA = new Arrange();
        BeanUtils.copyProperties(obj,saveA);

        // dt process
        DateTimeUtils.parseToObjectFromDateString(obj.getDt(),saveA);

        // category time process
        Category category = categoryRepository.getOne(saveA.getCategoryId());



        return null;
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
    CommonResponse update(@RequestBody ArrangeBO obj) {
        return null;
    }

    @Override
    CommonResponse modify(@RequestBody ArrangeBO obj) {
        return null;
    }

    @Override
    CommonResponse delete(@PathVariable String id) {
        return null;
    }
}
