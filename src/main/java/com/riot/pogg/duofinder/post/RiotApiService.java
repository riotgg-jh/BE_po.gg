package com.riot.pogg.duofinder.post;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class RiotApiService {

    @Value("${api.key}")
    private String riotApiKey;

    @Value("${api.url}")
    private String riotApiUrl;


    public boolean isSummonerNameValid(String gameName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = riotApiUrl + gameName + "?api_key=" + riotApiKey;

        try {
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}
