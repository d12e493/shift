package com.davis.shift.controller;

import com.davis.shift.bo.UserBO;
import com.davis.shift.dao.UserRepository;
import com.davis.shift.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PatchMapping(value = "{id}")
    public boolean update(@PathVariable("id") String id, @RequestBody UserBO userBO){

        User u = userRepository.getOne(id);

        try{
            if(StringUtils.isNotEmpty(userBO.getName())){
                u.setName(userBO.getName());
            }

            if(StringUtils.isNotEmpty(userBO.getPassword())){
                u.setPassword(DigestUtils.sha256Hex(userBO.getPassword()));
            }

            userRepository.save(u);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
