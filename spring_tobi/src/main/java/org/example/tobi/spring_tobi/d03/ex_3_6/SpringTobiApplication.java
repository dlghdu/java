package org.example.tobi.spring_tobi.d03.ex_3_6;

import org.example.tobi.spring_tobi.d01.ex_1_5.dao.CountingDaoFactory;
import org.example.tobi.spring_tobi.d03.ex_3_6.dao.UserDao_v1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        ApplicationContext context = new AnnotationConfigApplicationContext((CountingDaoFactory.class));
        UserDao_v1 userDao = context.getBean("userDao", UserDao_v1.class);

        int count = userDao.getCount();
        System.out.println(count);

        userDao.deleteAll();

        count = userDao.getCount();
        System.out.println(count);
    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
