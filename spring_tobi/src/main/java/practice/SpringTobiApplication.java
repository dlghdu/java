package practice;

import practice.e1.dao.UserDao;
import practice.e1.domain.User;
import practice.e1.dao.DaoFactory;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("32100");
        user.setName("123");
        user.setPassword("4321");

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
