package com.riot.pogg.userfind;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class userFindService {

    @Value("${api.key}")
    private String apiKey;

    public userFindDTO getAccountByRiotId(String summoners_name, String tag) {
        // Riot API URL
        String url = String.format(
                "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/%s/%s",
                summoners_name,
                tag
        );

        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey); // application.properties에서 가져온 API 키 사용

        try {
            ResponseEntity<userFindDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new org.springframework.http.HttpEntity<>(headers),
                    userFindDTO.class
            );
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Riot API 호출 실패 :" + e.getMessage());
        }
    }
}
