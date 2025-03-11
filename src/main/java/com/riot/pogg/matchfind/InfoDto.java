package com.riot.pogg.matchfind;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoDto {
    String endOfGameResult;
    long gameCreation;
    long gameDuration;
    long gameEndTimestamp;
    long gameId;
    String gameMode;
    String gameName;
    long gameStartTimestamp;
    String gameType;
    String gameVersion;
    int mapId;
    List<ParticipantDto> participants;
    String platformId;
    int queueId;
    List<TeamDto> teams;
    String tournamentCode;
}
