package com.davis.shift.dao;

import com.davis.shift.entity.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CommonRepository<User,String>{
    User findByEmail(String email);
}
