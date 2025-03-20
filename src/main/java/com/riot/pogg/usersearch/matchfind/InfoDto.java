package com.riot.pogg.usersearch.matchfind;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InfoDto {
    long gameDuration;
    long gameEndTimestamp;
    String gameMode;
    long gameStartTimestamp;
    String gameType;
    String gameVersion;
    int mapId;
    List<ParticipantDto> participants;
    int queueId;
    List<TeamDto> teams;
    String tournamentCode;
}
