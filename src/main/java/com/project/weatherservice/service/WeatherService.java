package com.project.weatherservice.service;

import com.project.weatherservice.dto.CurrentDto;
import com.project.weatherservice.dto.ForecastDto;
import com.project.weatherservice.dto.WeatherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final RestClient restClient;
    @Value("${openweather.api.key}")
    private String weatherApiKey;

    public WeatherResponseDto getWeather(JsonNode vWorldJsonNode) {
        String fullAddress = vWorldJsonNode.path("response").path("refined").path("text").asString();
        String location = vWorldJsonNode.path("response").path("input").path("address").asString();
        // 경도
        double lon = vWorldJsonNode.path("response").path("result").path("point").path("x").asDouble();
        // 위도
        double lat = vWorldJsonNode.path("response").path("result").path("point").path("y").asDouble();

        CurrentDto currentDto = fetchCurrentWeather(lat, lon);
        List<ForecastDto> forecastDtos = fetchForecastWeather(lat, lon);

        return WeatherResponseDto.builder()
                .today(LocalDate.now(ZoneId.of("Asia/Seoul")).toString())
                .location(location)
                .fullAddress(fullAddress)
                .currentDto(currentDto)
                .forecastDtos(forecastDtos)
                .build();
    }

    private CurrentDto fetchCurrentWeather(double lat, double lon) {
        String currentUrl = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=metric&lang=kr",
                lat, lon, weatherApiKey);
        JsonNode currentJsonNode = restClient.get()
                                             .uri(currentUrl)
                                             .retrieve()
                                             .body(JsonNode.class);
        return CurrentDto.builder()
                .condition(currentJsonNode.path("weather").get(0).path("description").asString())
                .icon(currentJsonNode.path("weather").get(0).path("icon").asString())
                .temp(currentJsonNode.path("main").path("temp").asDouble())
                .feelsLike(currentJsonNode.path("main").path("feels_like").asDouble())
                .humidity(currentJsonNode.path("main").path("humidity").asInt())
                .windSpeed(currentJsonNode.path("wind").path("speed").asDouble())
                .clouds(currentJsonNode.path("clouds").path("all").asInt())
                .build();
    }

    private List<ForecastDto> fetchForecastWeather(double lat, double lon) {
        String forecastUrl = String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=%s&units=metric&lang=kr",
                lat, lon, weatherApiKey);
        JsonNode forecastJsonNode = restClient.get()
                                              .uri(forecastUrl)
                                              .retrieve()
                                              .body(JsonNode.class);
        // today: yyyy-mm-dd 형식.
        String today = LocalDate.now(ZoneId.of("Asia/Seoul")).toString();
        List<ForecastDto> forecastDtos = new ArrayList<>();
        List<JsonNode> tempDayNodes = new ArrayList<>();

        for (JsonNode jsonNode : forecastJsonNode.path("list")) {
            // dt: Unix 시간.
            long dt = jsonNode.path("dt").asLong();
            // Unix 시간 변환. (nodeDate: yyyy-mm-dd 형식.)
            String nodeDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ZoneId.of("Asia/Seoul"))
                    .toLocalDate().toString();

            if (nodeDate.equals(today)) {
                continue;
            }

            tempDayNodes.add(jsonNode);
            if (tempDayNodes.size() == 8) {
                forecastDtos.add(analyzeDay(tempDayNodes, nodeDate));
                // 3시간 간격으로 8번 예보(24시간). 이후에는 날짜가 바뀌므로 리스트 초기화.
                tempDayNodes = new ArrayList<>();
                // 예보 4일치만 수집.
                if (forecastDtos.size() == 4) {
                    break;
                }
            }
        }
        return forecastDtos;
    }
    private ForecastDto analyzeDay(List<JsonNode> dayNodes, String date) {
        double minTemp = 999.0, maxTemp = -999.0;
        double feelsLikeAtMin = 0, feelsLikeAtMax = 0, totalFeelsLike = 0;
        String noonCond = "", noonIcon = "", midnightCond = "", midnightIcon = "";

        for (JsonNode jsonNode : dayNodes) {
            double temp = jsonNode.path("main").path("temp").asDouble();
            double feels = jsonNode.path("main").path("feels_like").asDouble();
            totalFeelsLike += feels;

            // 한국 시간 (KST)
            int hour = LocalDateTime.ofInstant(Instant.ofEpochSecond(jsonNode.path("dt").asLong()), ZoneId.of("Asia/Seoul")).getHour();

            if (temp < minTemp) {
                minTemp = temp;
                feelsLikeAtMin = feels;
            }
            if (temp > maxTemp) {
                maxTemp = temp;
                feelsLikeAtMax = feels;
            }

            if (hour == 12) {
                noonCond = jsonNode.path("weather").get(0).path("description").asString();
                noonIcon = jsonNode.path("weather").get(0).path("icon").asString();
            } else if (hour == 0) {
                midnightCond = jsonNode.path("weather").get(0).path("description").asString();
                midnightIcon = jsonNode.path("weather").get(0).path("icon").asString();
            }
        }

        return ForecastDto.builder()
                .date(date)
                .minTemp(minTemp)
                .maxTemp(maxTemp)
                .feelsLikeAtMin(feelsLikeAtMin)
                .feelsLikeAtMax(feelsLikeAtMax)
                .avgFeelsLike(ceil(totalFeelsLike / 8))
                .noonCondition(noonCond)
                .noonIcon(noonIcon)
                .midnightCondition(midnightCond)
                .midnightIcon(midnightIcon)
                .build();
    }

    // 소수점 2번째 자리까지만.
    private double ceil(double num) {
        return Math.round(num * 100) / 100.0;
    }
}
