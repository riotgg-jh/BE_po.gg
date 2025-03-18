package com.riot.pogg.duofinder.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostRequestDTO {

    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    @Size(max = 80, message = "내용은 최대 80자까지 입력 가능합니다.")
    private String content; // 내용

    @NotBlank(message = "카테고리는 필수 입력 항목입니다.")
    private String categoryId; // 카테고리 ID

    @NotBlank(message = "포지션은 필수 입력 항목입니다.")
    private String positionId; // 포지션 ID
}
