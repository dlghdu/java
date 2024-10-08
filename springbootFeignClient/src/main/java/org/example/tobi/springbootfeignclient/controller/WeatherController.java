package org.example.tobi.springbootfeignclient.controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootfeignclient.dto.weather.WeatherResponse;
import org.example.tobi.springbootfeignclient.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponse getWeatherData() {
        return weatherService.getWeatherData();
    }

}
