package org.example.tobi.springbootbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
- http?
- headers, body?
- url요청 방식
GET, POST, PUT, DELETE
- rest api?
- MVC패턴?
- 템플릿엔진?
- 지금 이거 update
- 그리고 delete
- 완성을 시켜버ㅏㅗ!!
 */

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}
