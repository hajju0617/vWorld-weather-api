package com.project.weatherservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor
public class VWorldService {
    private final RestClient restClient;
    @Value("${vworld.api.key}")
    private String vWorldApiKey;

    public JsonNode fetchVWorld(String location) {
        String validatedLocation = validateLocation(location);
        String geocoderUrl = String.format("https://api.vworld.kr/req/address?service=address&request=getCoord&key=%s&format=json&type=road&address=%s",
                vWorldApiKey, validatedLocation);

        JsonNode vWorldjsonNode = restClient.get()
                                            .uri(geocoderUrl)
                                            .retrieve()
                                            .body(JsonNode.class);

        if (vWorldjsonNode == null || !isResponseOk(vWorldjsonNode)) {
            throw new IllegalStateException("주소를 찾을 수 없습니다. 다시 입력해주세요.");
        }
        return vWorldjsonNode;
    }

    private String validateLocation(String location) {
        return (location == null || location.trim().isEmpty()) ? "서울" : location;
    }

    private boolean isResponseOk(JsonNode node) {
        return "OK".equals(node.path("response").path("status").asString());
    }
}
