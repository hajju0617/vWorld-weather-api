package com.project.weatherservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class WeatherResponseDto {
    private String today;
    private String location;
    private String fullAddress;
    private CurrentDto currentDto;
    private List<ForecastDto> forecastDtos;
}
