package com.davis.shift.event;

import com.davis.shift.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {
    @HandleBeforeCreate
    public void handleBeforeCreate(User u) {

        u.setPassword(DigestUtils.sha256Hex(u.getPassword()));
    }
}
