package com.davis.shift.controller;

import com.davis.shift.bo.CategoryBO;
import com.davis.shift.bo.CommonResponse;
import com.davis.shift.dao.CategoryRepository;
import com.davis.shift.entity.Category;
import com.davis.shift.util.CopyUtils;
import com.davis.shift.util.DateTimeUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path="/categories")
public class CategoryController  extends CommonController<CategoryBO>{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    CommonResponse create(@RequestBody CategoryBO obj) {

        try {
            Category c = new Category();
            c.setName(obj.getName());

            c.setStartAt(obj.getStartAt());
            c.setEndAt(obj.getEndAt());

            Duration d = Duration.between(c.getStartAt(),c.getEndAt());

            c.setTotal_hour((int)d.toHours());
            c.setTotal_minute((int)d.toMinutes());

            categoryRepository.save(c);

            obj.setId(c.getId());

            return new CommonResponse().setObject(obj);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    CommonResponse get(@PathVariable String id) {

        Category c = categoryRepository.getOne(id);

        CategoryBO bo = new CategoryBO();

        BeanUtils.copyProperties(c,bo);

        return new CommonResponse().setObject(bo);
    }

    @Override
    CommonResponse list() {

        List entityList = categoryRepository.findAll();
        List responseList = CopyUtils.copy(entityList,CategoryBO.class);

        return new CommonResponse().setContent(responseList);
    }

    @Override
    CommonResponse update(@RequestBody CategoryBO obj) {
        return null;
    }

    @Override
    CommonResponse modify(@RequestBody CategoryBO obj) {
        return null;
    }

    @Override
    CommonResponse delete(@PathVariable String id) {
        return null;
    }
}
