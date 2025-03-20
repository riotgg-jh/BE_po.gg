package com.riot.pogg.usersearch.matchfind;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetadataDTO {
    String dataVersion;
    String matchId;
    List<String> participants;
}
