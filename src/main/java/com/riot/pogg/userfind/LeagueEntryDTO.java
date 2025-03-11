package com.riot.pogg.userfind;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeagueEntryDTO {
    String leagueId;
    String summonerId;
    String puuid;
    String queueType;
    String tier;
    String rank;
    int leaguePoints;
    int wins;
    int losses;
    boolean hotStreak;
    boolean veteran;
    boolean freshBlood;
    boolean inactive;
}
