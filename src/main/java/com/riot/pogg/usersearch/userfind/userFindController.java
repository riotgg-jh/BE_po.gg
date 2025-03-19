package com.riot.pogg.usersearch.userfind;

import com.riot.pogg.usersearch.matchfind.InfoDto;
import com.riot.pogg.usersearch.matchfind.MatchDTO;
import com.riot.pogg.usersearch.matchfind.MatchFindService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/userFind")
public class userFindController {
    private final userFindService userFindService;
    private final MatchFindService matchFindService;

    public userFindController(userFindService userFindService, MatchFindService matchFindService) {
        this.userFindService = userFindService;
        this.matchFindService = matchFindService;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getAccountByRiotId(
            @RequestParam String summoners_name,
            @RequestParam String tag
    ) {
        try {
            userFindDTO userFindDTO = userFindService.getAccountByRiotId(summoners_name, tag);
            String puuid = userFindDTO.getPuuid();
            int count = 20;

            List<String> matchIds = userFindService.getMatchIdsByPuuid(puuid, count);
            Set<LeagueEntryDTO> entries = userFindService.getLeagueEntriesByPuuid(puuid);
            List<MatchDTO> matchDTO = matchFindService.getDetailsByMatchId(matchIds);
            SummonerDTO summoner = userFindService.getSummonerByPuuId(puuid);


            return ResponseEntity.ok().body(Map.of(
                    "userFindDTO", userFindDTO,
                    "SummonerDTO", summoner,
                    "soloEntries", entries.stream()
                            .filter(entry -> "RANKED_SOLO_5x5".equals(entry.getQueueType()))
                            .collect(Collectors.toList()),
                    "flexEntries", entries.stream()
                            .filter(entry -> "RANKED_FLEX_SR".equals(entry.getQueueType()))
                            .collect(Collectors.toList()),
                    "matchDetails", matchDTO
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }



}

