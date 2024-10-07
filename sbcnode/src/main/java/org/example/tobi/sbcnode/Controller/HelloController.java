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
//    show databases;
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
//
//select * from article;
//
//alter table article add file_path varchar(255);
//
//drop table member;
//
//INSERT INTO article (user_id, title, content) VALUES
//    ('user1', '게시물 제목 1', '게시물 내용 1'),
//            ('user2', '게시물 제목 2', '게시물 내용 2'),
//            ('user3', '게시물 제목 3', '게시물 내용 3'),
//            ('user4', '게시물 제목 4', '게시물 내용 4'),
//            ('user5', '게시물 제목 5', '게시물 내용 5'),
//            ('user6', '게시물 제목 6', '게시물 내용 6'),
//            ('user7', '게시물 제목 7', '게시물 내용 7'),
//            ('user8', '게시물 제목 8', '게시물 내용 8'),
//            ('user9', '게시물 제목 9', '게시물 내용 9'),
//            ('user10', '게시물 제목 10', '게시물 내용 10'),
//            ('user11', '게시물 제목 11', '게시물 내용 11'),
//            ('user12', '게시물 제목 12', '게시물 내용 12'),
//            ('user13', '게시물 제목 13', '게시물 내용 13'),
//            ('user14', '게시물 제목 14', '게시물 내용 14'),
//            ('user15', '게시물 제목 15', '게시물 내용 15'),
//            ('user16', '게시물 제목 16', '게시물 내용 16'),
//            ('user17', '게시물 제목 17', '게시물 내용 17'),
//            ('user18', '게시물 제목 18', '게시물 내용 18'),
//            ('user19', '게시물 제목 19', '게시물 내용 19'),
//            ('user20', '게시물 제목 20', '게시물 내용 20'),
//            ('user21', '게시물 제목 21', '게시물 내용 21'),
//            ('user22', '게시물 제목 22', '게시물 내용 22'),
//            ('user23', '게시물 제목 23', '게시물 내용 23'),
//            ('user24', '게시물 제목 24', '게시물 내용 24'),
//            ('user25', '게시물 제목 25', '게시물 내용 25'),
//            ('user26', '게시물 제목 26', '게시물 내용 26'),
//            ('user27', '게시물 제목 27', '게시물 내용 27'),
//            ('user28', '게시물 제목 28', '게시물 내용 28'),
//            ('user29', '게시물 제목 29', '게시물 내용 29'),
//            ('user30', '게시물 제목 30', '게시물 내용 30'),
//            ('user31', '게시물 제목 31', '게시물 내용 31'),
//            ('user32', '게시물 제목 32', '게시물 내용 32'),
//            ('user33', '게시물 제목 33', '게시물 내용 33'),
//            ('user34', '게시물 제목 34', '게시물 내용 34'),
//            ('user35', '게시물 제목 35', '게시물 내용 35');

