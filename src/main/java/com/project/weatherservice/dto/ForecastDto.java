package com.project.weatherservice.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ForecastDto {
    private String date;                // 예보 날짜.
    private double minTemp;             // 최저 기온.
    private double feelsLikeAtMin;      // 최저기온 시점 체감온도.
    private double maxTemp;             // 최고 기온.
    private double feelsLikeAtMax;      // 최고기온 시점 체감온도.
    private double avgFeelsLike;        // 평균체감온도.

    private String noonCondition;       // 정오 날씨상황.
    private String noonIcon;            // 정오 날씨 아이콘.
    private String midnightCondition;   // 자정 날씨상황.
    private String midnightIcon;        // 자정 날씨 아이콘.

}
