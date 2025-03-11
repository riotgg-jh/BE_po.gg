package com.riot.pogg.matchfind;

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
    PerksDto perks;
    String puuid;
    boolean win;
}
