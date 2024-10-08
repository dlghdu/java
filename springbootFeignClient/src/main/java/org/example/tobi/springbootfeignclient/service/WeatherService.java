package org.example.tobi.springbootfeignclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootfeignclient.client.WeatherClient;
import org.example.tobi.springbootfeignclient.dto.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final ObjectMapper objectMapper;
    @Value("${weather.api.key}")
    private String serviceKey;

    public WeatherResponse getWeatherData() {
        int numOfRows = 10;
        int pageNo = 1;
        String dataType = "JSON";
        String baseDate = "20241008";
        String baseTime = "1400";
        int nx = 60;
        int ny = 127;

        try {
            String weatherData = weatherClient.getWeatherData(
                    serviceKey,
                    numOfRows,
                    pageNo,
                    dataType,
                    baseDate,
                    baseTime,
                    nx,
                    ny
            );
            return objectMapper.readValue(weatherData, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
