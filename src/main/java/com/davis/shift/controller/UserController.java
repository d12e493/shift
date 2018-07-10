package com.davis.shift.controller;

import com.davis.shift.bo.CommonResponse;
import com.davis.shift.bo.UserBO;
import com.davis.shift.dao.UserRepository;
import com.davis.shift.entity.User;
import com.davis.shift.util.CopyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController extends CommonController<UserBO>{

    @Autowired
    private UserRepository userRepository;

    @Override
    CommonResponse get(@PathVariable("id") String id) {
        return new CommonResponse().setObject(userRepository.getOne(id));
    }

    @Override
    CommonResponse create(@RequestBody UserBO obj) {

        User u = new User();
        u.setName(obj.getName());
        u.setEmail(obj.getEmail());
        u.setPassword(DigestUtils.sha256Hex(obj.getPassword()));

        userRepository.save(u);

        obj.setId(u.getId());

        return new CommonResponse().actionStatus(true).setObject(obj);
    }

    @Override
    CommonResponse list() {

        List<User> dbUserList = userRepository.findAll();

        List<UserBO> userList = CopyUtils.copy(dbUserList,UserBO.class);

        return new CommonResponse().setContent(userList);
    }

    @Override
    CommonResponse update(@RequestBody UserBO obj) {

        User dbUser = userRepository.getOne(obj.getId());

        if(dbUser!=null){
            UserBO bo = new UserBO();
            dbUser.setName(obj.getName());

            userRepository.save(dbUser);

            return new CommonResponse().actionStatus(true);
        }

        return null;
    }

    @Override
    CommonResponse modify(@RequestBody UserBO obj) {
        return null;
    }

    @Override
    CommonResponse delete(@PathVariable String id) {

        User dbUser = userRepository.getOne(id);
        if(dbUser!=null){

            dbUser.setEmail(dbUser.getEmail()+System.currentTimeMillis());
            dbUser.setDeletedAt(Calendar.getInstance());

            userRepository.save(dbUser);

            return new CommonResponse().actionStatus(true);
        }

        return null;
    }

    @GetMapping(path = "/test")
    public String test(){
        return "test";
    }
}
