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
import org.springframework.web.client.RestTemplate;

@Controller
public class userFindController {
    private final userFindService userFindService;

    public userFindController(userFindService userFindService) {
        this.userFindService = userFindService;
    }


    @GetMapping("/profile")
    public String getAccountByRiotId(
            @RequestParam String summoners_name,
            @RequestParam String tag,
            Model model
    ) {

        try {
            userFindDTO userFindDTO = userFindService.getAccountByRiotId(summoners_name, tag);
            model.addAttribute("puuid", userFindDTO.getPuuid());
            return "userFindResult";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Error : " + e.getMessage());
            return "errorpage";
        }



    }
}
