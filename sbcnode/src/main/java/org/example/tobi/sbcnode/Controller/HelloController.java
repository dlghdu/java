package org.example.tobi.sbcnode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "hello";
    }

}


    //데이터베이스 설정\\
//show databases;
//
//use java_basic;
//
//show tables;
//
//CREATE TABLE member (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        user_id VARCHAR(30) NOT NULL,
//password VARCHAR(50) NOT NULL,
//user_name VARCHAR(10) NOT NULL
//);
//
//CREATE TABLE article (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        user_id VARCHAR(30) NOT NULL,
//title VARCHAR(100) NOT NULL,
//content TEXT NOT NULL,
//created DATETIME DEFAULT CURRENT_TIMESTAMP,
//updated DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
//);
//
//select * from member;
