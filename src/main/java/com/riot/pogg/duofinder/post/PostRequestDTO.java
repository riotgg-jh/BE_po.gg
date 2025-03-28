package com.riot.pogg.duofinder.post;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Getter
@Setter
public class PostRequestDTO {

    @NotBlank(message = "소환사 이름은 필수 입력 항목입니다.")
    @JsonProperty("gameName")
    private String gameName;

    @JsonProperty("myPosition")
    private List<String> myPosition;

    @JsonProperty("lookingForPosition")
    private List<String> lookingForPosition;

    @NotBlank(message = "카테고리는 필수 선택 항목입니다.")
    @JsonProperty("categoryId")
    private String categoryId;

    @NotBlank(message = "포지션은 필수 선택 항목입니다.")
    @JsonProperty("positionId")
    private String positionId;

    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    @Size(max = 80, message = "내용은 최대 80자까지 입력 가능합니다.")
    @JsonProperty("content")
    private String content;

}
