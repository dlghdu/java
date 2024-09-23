package org.example.tobi.spring_tobi.d01.ex_1_4.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(getConnection());
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(getConnection());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(getConnection());
    }

    @Bean
    public ConnectionMaker getConnection() {
        return new DConnectionMaker();
    }

}
