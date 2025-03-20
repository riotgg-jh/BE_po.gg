package com.riot.pogg.duofinder.post;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class RiotApiService {

    private static final String RIOT_API_KEY = "RIOT_API_KEY";
    private static final String RIOT_API_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";

    public boolean isSummonerNameValid(String summonerName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = RIOT_API_URL + summonerName + "?api_key=" + RIOT_API_KEY;

        try {
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}
