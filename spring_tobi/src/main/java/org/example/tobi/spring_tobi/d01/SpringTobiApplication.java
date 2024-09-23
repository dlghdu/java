package org.example.tobi.spring_tobi.d01;

import org.example.tobi.spring_tobi.d01.ex_1_5.dao.CountingDaoFactory;
import org.example.tobi.spring_tobi.d01.ex_1_5.dao.UserDao;
import org.example.tobi.spring_tobi.d01.ex_1_5.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        ApplicationContext context = new AnnotationConfigApplicationContext((CountingDaoFactory.class));

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("32100");
        user.setName("123");
        user.setPassword("4321");

        dao.add(user);

        User user1 = dao.get(user.getId());
        System.out.println("aa " + user1.getName());

    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
