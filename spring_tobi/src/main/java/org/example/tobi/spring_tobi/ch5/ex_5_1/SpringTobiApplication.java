package org.example.tobi.spring_tobi.ch5.ex_5_1;

import org.example.tobi.spring_tobi.d01.ex_1_5.dao.CountingDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        ApplicationContext context = new AnnotationConfigApplicationContext((CountingDaoFactory.class));

    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}

// ALTER TABLE users ADD COLUMN LEVEL tinyint;
// ALTER TABLE users ADD COLUMN Login int;
// ALTER TABLE users ADD COLUMN Recommend int;
