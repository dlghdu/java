package org.example.tobi.spring_tobi;

import ex_1_3.dao.DConnectionMaker;
import ex_1_3.dao.UserDao;
import ex_1_3.domain.User;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        UserDao dao = new UserDao(new DConnectionMaker());

        User user = new User();
        user.setId("tobi3");
        user.setName("Tobi");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록성공!");
        
        User getUser = dao.get(user.getId());

        System.out.println(getUser.getName());
        System.out.println(getUser.getPassword());

        System.out.println(getUser.getId() + " 조회 성공");
    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}