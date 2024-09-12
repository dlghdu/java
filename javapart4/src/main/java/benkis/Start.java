package benkis;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Start {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out,true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        Notice notice = new Noticeimpl();

        while(true) {
            int choice = notice.printMenu();
            switch (choice) {
                case 1:
                    notice.login();
                    break;
                case 2:
                    notice.signup();
                    break;
                case 3:
                    break;
                case 4:
                    notice.riwrite();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("잘가");
                    return;
                default:
                    System.out.println("다시");
                    break;
            }
        }
    }
}

/*
show databases;

CREATE DATABASE Notice
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

use Notice;

show tables;

CREATE TABLE USER (
                      USERID varchar(20),
                      PASSWORD varchar(20),
                      AGE int(30),
                      USERNAME varchar(20),
                      PHONE varchar(15)
);

CREATE TABLE Content (
                    NUMBER int auto_increment primary key,
                    TITLE varchar(20),
                    NEONG varchar(50),
                    DATE varchar(10)
);

alter table USER modify column USERID int auto_increment primary key;
alter table USER modify column USERNAME varchar(5) not null;

SELECT * FROM USER;
 */
