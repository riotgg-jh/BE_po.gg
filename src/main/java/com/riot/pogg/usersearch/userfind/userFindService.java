package com.riot.pogg.usersearch.userfind;

import com.riot.pogg.usersearch.matchfind.MatchDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public List<String> getMatchIdsByPuuid(String puuid, int count) {
        String url = String.format(
                "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/%s/ids?start=0&count=%d",
                puuid, count
        );

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey);

        try {
            ResponseEntity<List> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new org.springframework.http.HttpEntity<>(headers),
                    List.class
            );
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Match ID 가져오기 실패: " + e.getMessage());
        }
    }

    public Set<LeagueEntryDTO> getLeagueEntriesByPuuid(String puuid) {
        String url = String.format(
                "https://kr.api.riotgames.com/lol/league/v4/entries/by-puuid/%s",
                puuid
        );

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey);

        try {
            ResponseEntity<Set<LeagueEntryDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new org.springframework.http.HttpEntity<>(headers),
                    new ParameterizedTypeReference<Set<LeagueEntryDTO>>() {}
            );
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("리그 정보 가져오기 실패: " + e.getMessage());
        }
    }

    public SummonerDTO getSummonerByPuuId(String puuid) {
        // Riot API URL
        String url = String.format(
                "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/%s",
                puuid
        );

        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", apiKey); // application.properties에서 가져온 API 키 사용

        try {
            ResponseEntity<SummonerDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new org.springframework.http.HttpEntity<>(headers),
                    SummonerDTO.class
            );
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Riot API 호출 실패 :" + e.getMessage());
        }
    }
}
