package com.project.weatherservice.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CurrentDto {
    private String condition;    // 날씨 상황.
    private String icon;         // 아이콘 코드.
    private double temp;         // 현재 기온.
    private double feelsLike;    // 체감 온도.
    private int humidity;        // 습도.
    private double windSpeed;    // 풍속.
    private int clouds;          // 흐림 정도. (%)
}
