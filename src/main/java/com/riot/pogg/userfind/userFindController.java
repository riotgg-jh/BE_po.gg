package com.riot.pogg.userfind;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/riot")
public class userFindController {
    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/account/v1/accounts/by-riot-id")
    public String getAccountByRiotId(
            @RequestParam String summoners_name,
            @RequestParam String tag,
            Model model
    ) {
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
            // Riot API 호출
            ResponseEntity<userFindDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new org.springframework.http.HttpEntity<>(headers),
                    userFindDTO.class
            );
            model.addAttribute("puuid", response.getBody().getPuuid());

        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
        }

        return "userFindResult";
    }
}
