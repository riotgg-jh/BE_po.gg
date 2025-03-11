package com.riot.pogg.matchfind;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDto {
    List<BanDto> bans;
    ObjectivesDto objectives;
    int teamId;
    boolean win;
}
