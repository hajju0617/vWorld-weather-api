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
![Image](https://github.com/user-attachments/assets/ba023fb4-d451-4f2a-8c46-0672c44d2ce3)

<img width="1338" height="1112" alt="Image" src="https://github.com/user-attachments/assets/e9ddf1fc-a35f-4be5-9e3e-f654d9431dc0" />

`JSON Ex) 수서역, 동대구역`
- 수서역
```
{
    "currentDto": {
        "clouds": 75,
        "condition": "튼구름",
        "feelsLike": -0.09,
        "humidity": 65,
        "icon": "04n",
        "temp": 2.53,
        "windSpeed": 2.57
    },
    "forecastDtos": [
        {
            "avgFeelsLike": -3.93,
            "date": "2026-01-10",
            "feelsLikeAtMax": -1.5,
            "feelsLikeAtMin": -10.5,
            "maxTemp": 4.14,
            "midnightCondition": "튼구름",
            "midnightIcon": "04n",
            "minTemp": -3.5,
            "noonCondition": "가벼운 눈",
            "noonIcon": "13d"
        },
        {
            "avgFeelsLike": -13.28,
            "date": "2026-01-11",
            "feelsLikeAtMax": -11.61,
            "feelsLikeAtMin": -14.8,
            "maxTemp": -4.61,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -7.8,
            "noonCondition": "약간의 구름이 낀 하늘",
            "noonIcon": "02d"
        },
        {
            "avgFeelsLike": -5.96,
            "date": "2026-01-12",
            "feelsLikeAtMax": -0.58,
            "feelsLikeAtMin": -11.39,
            "maxTemp": 3.83,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -7.62,
            "noonCondition": "튼구름",
            "noonIcon": "04d"
        },
        {
            "avgFeelsLike": -8.89,
            "date": "2026-01-13",
            "feelsLikeAtMax": -1.05,
            "feelsLikeAtMin": -13.75,
            "maxTemp": 2.76,
            "midnightCondition": "가벼운 눈",
            "midnightIcon": "13n",
            "minTemp": -7.14,
            "noonCondition": "튼구름",
            "noonIcon": "04d"
        }
    ],
    "fullAddress": "서울특별시 강남구 광평로 270 (수서동)",
    "location": "서울 수서역",
    "today": "2026-01-09"
}
```
- 동대구역
```
{
    "currentDto": {
        "clouds": 0,
        "condition": "맑음",
        "feelsLike": -2.1,
        "humidity": 64,
        "icon": "01n",
        "temp": -2.1,
        "windSpeed": 0.51
    },
    "forecastDtos": [
        {
            "avgFeelsLike": -2.34,
            "date": "2026-01-10",
            "feelsLikeAtMax": 2.69,
            "feelsLikeAtMin": -4.77,
            "maxTemp": 6.94,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -2.1,
            "noonCondition": "약간의 구름이 낀 하늘",
            "noonIcon": "02d"
        },
        {
            "avgFeelsLike": -10.04,
            "date": "2026-01-11",
            "feelsLikeAtMax": -8.49,
            "feelsLikeAtMin": -11.4,
            "maxTemp": -1.9,
            "midnightCondition": "튼구름",
            "midnightIcon": "04n",
            "minTemp": -5.35,
            "noonCondition": "튼구름",
            "noonIcon": "04d"
        },
        {
            "avgFeelsLike": -5.19,
            "date": "2026-01-12",
            "feelsLikeAtMax": 0.92,
            "feelsLikeAtMin": -9.35,
            "maxTemp": 3.28,
            "midnightCondition": "맑음",
            "midnightIcon": "01n",
            "minTemp": -6.73,
            "noonCondition": "맑음",
            "noonIcon": "01d"
        },
        {
            "avgFeelsLike": -4.0,
            "date": "2026-01-13",
            "feelsLikeAtMax": -1.65,
            "feelsLikeAtMin": -9.84,
            "maxTemp": 2.04,
            "midnightCondition": "구름조금",
            "midnightIcon": "03n",
            "minTemp": -3.25,
            "noonCondition": "온흐림",
            "noonIcon": "04d"
        }
    ],
    "fullAddress": "대구광역시 동구 동대구로 550 (신암동)",
    "location": "동대구역",
    "today": "2026-01-09"
}
```
