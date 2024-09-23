package org.example.tobi.spring_tobi.d03.ex_3_1;

import org.example.tobi.spring_tobi.d01.ex_1_5.dao.CountingDaoFactory;
import org.example.tobi.spring_tobi.d03.ex_3_1.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        ApplicationContext context = new AnnotationConfigApplicationContext((CountingDaoFactory.class));
        context.getBean("userDao", UserDao.class);
    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
