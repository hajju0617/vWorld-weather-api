package com.project.weatherservice.controller;

import com.project.weatherservice.dto.WeatherResponseDto;
import com.project.weatherservice.service.VWorldService;
import com.project.weatherservice.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;


@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final VWorldService vWorldService;
    private final WeatherService weatherService;


    @GetMapping("/weather")
    public ResponseEntity<Object> getWeather(@RequestParam("location") String location) {
        try {
            JsonNode vWorldJsonNode = vWorldService.fetchVWorld(location);
            WeatherResponseDto weatherResponseDto = weatherService.getWeather(vWorldJsonNode);
            return ResponseEntity.ok(weatherResponseDto);
        } catch (IllegalStateException ie) {
            return ResponseEntity.badRequest().body(ie.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("죄송합니다. 서버측에서 오류가 발생하였습니다. 잠시 후 다시 시도해 주세요.");
        }
    }
}


