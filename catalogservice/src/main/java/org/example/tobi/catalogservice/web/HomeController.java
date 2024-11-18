package org.example.tobi.catalogservice.web;

import lombok.RequiredArgsConstructor;
import org.example.tobi.catalogservice.config.PolarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final PolarProperties polarProperties;

    @GetMapping("/")
    public String greeting() {
        return polarProperties.getGreeting();
    }

}