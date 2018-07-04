package com.davis.shift.configuration;

import com.davis.shift.dao.impl.CustomJpaRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages="com.davis.shift",
        repositoryFactoryBeanClass = CustomJpaRepositoryFactoryBean.class
)
@EnableTransactionManagement
public class PersistenceContext {
}
