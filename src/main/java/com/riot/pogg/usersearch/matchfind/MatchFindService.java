package com.riot.pogg.usersearch.matchfind;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchFindService {

    @Value("${api.key}")
    private String apiKey;

    public List<MatchDTO> getDetailsByMatchId(List<String> matchIds) {
        String apiUrlTemplate = "https://asia.api.riotgames.com/lol/match/v5/matches/%s";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey);

        List<MatchDTO> matchDetails = new ArrayList<>();

        for (String matchId : matchIds) {
            String url = String.format(apiUrlTemplate, matchId);
            try {
                ResponseEntity<MatchDTO> response = restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        new org.springframework.http.HttpEntity<>(headers),
                        MatchDTO.class
                );
                // 성공적으로 응답을 받았다면 리스트에 추가
                matchDetails.add(response.getBody());
            } catch (Exception e) {
                System.err.println("매치 정보를 가져오는 중 오류 발생 (matchId: " + matchId + "): " + e.getMessage());
            }
        }
        return matchDetails;
    }
}
