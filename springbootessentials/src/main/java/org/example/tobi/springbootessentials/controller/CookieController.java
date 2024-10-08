package org.example.tobi.springbootessentials.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 정보를 클라이언트 PC에 저장함.
public class CookieController {

    @GetMapping("/setcookie")
    public String setCookiePage() {
        return "setcookie";
    }

    @PostMapping("/setcookie")
    public String setCookie(
            @RequestParam String username,
            HttpServletResponse reponse,
            Model model
    ) {
        // 쿠키 생성
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(7 * 24 * 60 * 60); // 1주일
        cookie.setHttpOnly(true); // HttpOnly?
        cookie.setPath("/");

        reponse.addCookie(cookie);

        model.addAttribute("message", "쿠키가 설정되었습니다.");
        return "resultcookie";
    }

    // 쿠키 읽기
    @GetMapping("/getcookie")
    public String getCookie(
            HttpServletRequest request,
            Model model
    ) {
        Cookie[] cookies = request.getCookies();
        String username = null;

        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie.getName().equals("username") ) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        if ( username != null ) {
            model.addAttribute("username", username);
            model.addAttribute("message", "쿠키에서 사용자 정보를 읽었습니다.");
        } else {
            model.addAttribute("message", "쿠키가 존재하지 않습니다.");
        }

        return "resultcookie";
    }

    @GetMapping("/deletecookie")
    public String deleteCookie(
            HttpServletResponse response,
            Model model
    ) {

        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");

        response.addCookie(cookie);

        model.addAttribute("message", "쿠키가 삭제되었습니다.");

        return "resultcookie";

    }

}
