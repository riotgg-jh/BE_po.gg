package com.riot.pogg.usersearch.matchfind;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PerksDto {
    PerkStatsDto statPerks;
    List<PerkStyleDto> styles;
}
