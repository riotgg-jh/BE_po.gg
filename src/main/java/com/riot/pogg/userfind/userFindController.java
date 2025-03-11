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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            String puuid = userFindDTO.getPuuid();
            int count = 20;

            List<String> matchIds = userFindService.getMatchIdsByPuuid(puuid, count);
            model.addAttribute("puuid", userFindDTO.getPuuid());
            model.addAttribute("matchIds", matchIds);

            Set<LeagueEntryDTO> entries = userFindService.getLeagueEntriesByPuuid(puuid);

            List<LeagueEntryDTO> soloEntries = entries.stream()
                    .filter(entry -> "RANKED_SOLO_5x5".equals(entry.getQueueType()))
                    .collect(Collectors.toList());

            List<LeagueEntryDTO> flexEntries = entries.stream()
                    .filter(entry -> "RANKED_FLEX_SR".equals(entry.getQueueType()))
                    .collect(Collectors.toList());

            model.addAttribute("soloEntries", soloEntries);
            model.addAttribute("flexEntries", flexEntries);

            return "userFindResult";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Error : " + e.getMessage());
            return "errorpage";
        }



    }
}
