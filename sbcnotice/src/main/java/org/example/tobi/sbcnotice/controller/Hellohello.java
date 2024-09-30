package org.example.tobi.sbcnotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hellohello {

    @GetMapping("/hellohello")
    public String hellohello() {
        System.out.println("hi hello");
        return "hello";
    }

}

//show databases ;
//
//use java_basic;
//
//show tables ;
//
//select * from user;
//
//create table noticee (
//        number bigint auto_increment primary key,
//        title varchar(20),
//day varchar(20),
//name varchar(20),
//email varchar(30),
//phone varchar(20),
//userid varchar(30),
//password varchar(50)
//);
//
//select * from noticee;

