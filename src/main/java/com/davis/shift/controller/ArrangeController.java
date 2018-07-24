package com.davis.shift.controller;

import com.davis.shift.bo.ArrangeBO;
import com.davis.shift.bo.CommonResponse;
import com.davis.shift.bo.UserArrange;
import com.davis.shift.bo.UserBO;
import com.davis.shift.dao.ArrangeRepository;
import com.davis.shift.dao.CategoryRepository;
import com.davis.shift.dao.UserRepository;
import com.davis.shift.entity.Arrange;
import com.davis.shift.entity.Category;
import com.davis.shift.entity.User;
import com.davis.shift.util.DateTimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/arranges")
public class ArrangeController extends CommonController<ArrangeBO>{

    @Autowired
    private ArrangeRepository arrangeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping(path = "/users/{start}~{end}")
    public CommonResponse queryUser(@PathVariable String start,@PathVariable String end){

        List<UserArrange> userArrangeList = new ArrayList<>();

        LocalDate startDate = DateTimeUtils.toDate(start);

        LocalDate endDate = DateTimeUtils.toDate(end);

        List<User> userList = userRepository.findAll();

        userList.forEach(user->{
            UserArrange ua = new UserArrange();

            ua.setUser(user.toObj(UserBO.class));

            List<Arrange> arrangeList = arrangeRepository.findByDtBetweenAndUserIdEquals(startDate,endDate,user.getId());
            Map arrangeMap = arrangeList.stream().collect(Collectors.toMap(x->x.getDt().toString(),Function.identity()));

            ua.setArrangeMap(arrangeMap);

            userArrangeList.add(ua);
        });

        return new CommonResponse().setContent(userArrangeList);
    }
}
