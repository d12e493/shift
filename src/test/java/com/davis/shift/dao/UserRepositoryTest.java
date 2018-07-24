package com.davis.shift.dao;

import com.davis.shift.entity.QUser;
import com.davis.shift.entity.User;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @Autowired
    private UserRepository userRepository;

    @Test
    // example by predicate
    public void findAllByPredicate() {
        QUser user = QUser.user;

        Sort sort = new Sort(Sort.Direction.DESC, "email");

        Pageable pageable = PageRequest.of(0, 10, sort);

        Page<User> userPage = userRepository.findAll(
                user.email.endsWith("@gmail.com")
                        .and(user.name.startsWith("lu"))
                        .and(user.id.in(Arrays.asList("ABC", "Davis"))), pageable
        );

        System.out.println(ReflectionToStringBuilder.toString(userPage));
    }

    @Test
    // example by SQL
    public void findAllBySQL() {
        QUser user = QUser.user;

        List userList = queryFactory.selectFrom(user)
                .select(user.email, user.name)
                .orderBy(user.email.desc())
                .offset(1)
                .limit(10)
                .fetch()
                .stream()
                .map(tuple -> {
                    Map<String, String> map = new LinkedHashMap<>();
                    map.put("name", tuple.get(user.name));
                    map.put("email", tuple.get(user.email));
                    return map;
                }).collect(Collectors.toList());

        System.out.println(ReflectionToStringBuilder.toString(userList));


        QueryResults<Tuple> userResult = queryFactory.selectFrom(user)
                .select(user.email, user.name)
                .orderBy(user.email.desc())
                .offset(1)
                .limit(10)
                .fetchResults();

        System.out.println(ReflectionToStringBuilder.toString(userResult));
    }
}
