package com.example.sbcboardweather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherBoardController {

    @GetMapping("/board")
    public String signup() {
        return "weatherboardlist";
    }

}
