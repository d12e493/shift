package com.davis.shift.controller;

import com.davis.shift.bo.CommonResponse;
import com.davis.shift.bo.RegionBO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/regions")
public class RegionController extends CommonController<RegionBO>{
    @Override
    CommonResponse create(@RequestBody RegionBO obj) {
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
    CommonResponse update(@RequestBody RegionBO obj) {
        return null;
    }

    @Override
    CommonResponse modify(@RequestBody RegionBO obj) {
        return null;
    }

    @Override
    CommonResponse delete(@PathVariable String id) {
        return null;
    }
}
