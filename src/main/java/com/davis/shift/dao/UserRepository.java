package com.davis.shift.dao;

import com.davis.shift.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User,String>,QuerydslPredicateExecutor<User> {
    User findByEmail(String email);
}
