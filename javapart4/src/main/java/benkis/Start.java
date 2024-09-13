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
                    notice.showall();
                    break;
                case 4:
                    notice.riwrite();
                    break;
                case 5:
                    notice.fixwrite();
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
                      USERID int auto_increment primary key,
                      PASSWORD varchar(20),
                      AGE int(30),
                      USERNAME varchar(5) not null,
                      PHONE varchar(15)
);

CREATE TABLE Content (
                         NUMBER int auto_increment primary key,
                         TITLE varchar(20),
                         NEONG varchar(50),
                         DATE varchar(20) not null
);

SELECT * FROM Content;

SELECT * FROM USER;

drop table Content;

ALTER TABLE USER MODIFY USERNAME varchar(10) not null;
ALTER TABLE USER MODIFY AGE int(99);
*/

/*
show databases;

CREATE DATABASE Notice
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

use Notice;

show tables;

CREATE TABLE USER (
        ID int auto_increment primary key,
        USERID varchar(10) not null unique,
PASSWORD varchar(20) not null,
AGE int(99),
USERNAME varchar(10) not null,
PHONE varchar(15)
);

CREATE TABLE Content (
        NUMBER int auto_increment primary key,
        TITLE varchar(10) not null,
NEONG varchar(20) not null,
DATE varchar(20) not null
        );

SELECT * FROM Content;

SELECT * FROM USER;

drop table USER;
drop table Content;
*/
