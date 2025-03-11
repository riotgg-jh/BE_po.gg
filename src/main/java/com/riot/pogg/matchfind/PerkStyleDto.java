package com.riot.pogg.matchfind;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerkStyleDto {
    String description;
    List<PerkStyleSelectionDto> selections;
    int style;
}
