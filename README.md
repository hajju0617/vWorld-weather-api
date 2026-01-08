### [V-WORLD](https://www.vworld.kr/)와 [OpenWeatherMap](https://openweathermap.org/)의 API를 사용해서 만든 일기예보 서비스.

- 위도, 경도 값을 얻기 위해 사용한 API
  - https://www.vworld.kr/dev/v4dv_geocoderguide2_s001.do
- 현재 날씨, 5일/3시간 예보를 얻기 위해 사용한 API
  - https://openweathermap.org/current
  - https://openweathermap.org/forecast5
---

- [Bug - JSON 응답이 {}(빈 객체)로 나오는 문제](https://velog.io/@hajju/Jackson-Bug-JSON-%EC%9D%91%EB%8B%B5%EC%9D%B4-%EB%B9%88-%EA%B0%9D%EC%B2%B4%EB%A1%9C-%EB%82%98%EC%98%A4%EB%8A%94-%EB%AC%B8%EC%A0%9C)
- [What - RestClient (with WebClient, RestTemplate)](https://velog.io/@hajju/Spring-What-RestClient-with-WebClient-RestTemplate)
- [JSON 데이터를 JsonNode로 받을 경우.](https://velog.io/@hajju/JSON-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%A5%BC-JsonNode%EB%A1%9C-%EB%B0%9B%EC%9D%84-%EA%B2%BD%EC%9A%B0)

---

`Ex 서울역, 동대구역`
- 서울역
```
{
    "currentDto": {
        "clouds": 0,
        "condition": "맑음",
        "feelsLike": -11.14,
        "humidity": 57,
        "icon": "01n",
        "temp": -8.16,
        "windSpeed": 1.54
    },
    "forecastDtos": [
        {
            "avgFeelsLike": -4.42,
            "date": "2026-01-09",
            "feelsLikeAtMax": -0.71,
            "feelsLikeAtMin": -6.82,
            "maxTemp": 1.94,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -6.82,
            "noonCondition": "온흐림",
            "noonIcon": "04d"
        },
        {
            "avgFeelsLike": -3.09,
            "date": "2026-01-10",
            "feelsLikeAtMax": 0.15,
            "feelsLikeAtMin": -9.57,
            "maxTemp": 4.83,
            "midnightCondition": "실 비",
            "midnightIcon": "10n",
            "minTemp": -2.77,
            "noonCondition": "가벼운 눈",
            "noonIcon": "13d"
        },
        {
            "avgFeelsLike": -12.73,
            "date": "2026-01-11",
            "feelsLikeAtMax": -10.5,
            "feelsLikeAtMin": -15.43,
            "maxTemp": -3.76,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -8.43,
            "noonCondition": "구름조금",
            "noonIcon": "03d"
        },
        {
            "avgFeelsLike": -7.4,
            "date": "2026-01-12",
            "feelsLikeAtMax": -1.65,
            "feelsLikeAtMin": -14.14,
            "maxTemp": 3.21,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -8.56,
            "noonCondition": "구름조금",
            "noonIcon": "03d"
        }
    ],
    "fullAddress": "서울특별시 중구 만리재로33길 21 (만리동1가,LIG 서울역 리가)",
    "location": "서울역",
    "today": "2026-01-08"
}
```
- 동대구역
```
{
    "currentDto": {
        "clouds": 0,
        "condition": "맑음",
        "feelsLike": -8.48,
        "humidity": 33,
        "icon": "01n",
        "temp": -5.1,
        "windSpeed": 2.06
    },
    "forecastDtos": [
        {
            "avgFeelsLike": -2.83,
            "date": "2026-01-09",
            "feelsLikeAtMax": 4.69,
            "feelsLikeAtMin": -8.06,
            "maxTemp": 4.69,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -4.85,
            "noonCondition": "맑음",
            "noonIcon": "01d"
        },
        {
            "avgFeelsLike": -1.54,
            "date": "2026-01-10",
            "feelsLikeAtMax": 3.76,
            "feelsLikeAtMin": -3.46,
            "maxTemp": 7.68,
            "midnightCondition": "온흐림",
            "midnightIcon": "04n",
            "minTemp": -1.0,
            "noonCondition": "실 비",
            "noonIcon": "10d"
        },
        {
            "avgFeelsLike": -8.72,
            "date": "2026-01-11",
            "feelsLikeAtMax": -7.71,
            "feelsLikeAtMin": -12.69,
            "maxTemp": -1.79,
            "midnightCondition": "구름조금",
            "midnightIcon": "03n",
            "minTemp": -5.95,
            "noonCondition": "온흐림",
            "noonIcon": "04d"
        },
        {
            "avgFeelsLike": -6.59,
            "date": "2026-01-12",
            "feelsLikeAtMax": 0.4,
            "feelsLikeAtMin": -10.03,
            "maxTemp": 2.9,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -7.46,
            "noonCondition": "온흐림",
            "noonIcon": "04d"
        }
    ],
    "fullAddress": "대구광역시 동구 동대구로 550 (신암동)",
    "location": "동대구역",
    "today": "2026-01-08"
}
```
