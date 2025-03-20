package com.riot.pogg.usersearch.matchfind;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantDto {
    int champLevel;
    int championId;
    String championName;
    int assists;
    int deaths;
    int kills;
    int goldEarned;
    int item0;
    int item1;
    int item2;
    int item3;
    int item4;
    int item5;
    int item6;
    int participantId;
    int profileIcon;
    int summoner1Id;
    int summoner2Id;
    PerksDto perks;
    String puuid;
    String riotIdGameName;
    String riotIdTagline;
    boolean win;
    ChallengesDto challenges;
}
