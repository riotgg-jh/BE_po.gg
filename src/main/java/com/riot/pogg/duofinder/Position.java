package com.riot.pogg.duofinder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Position {
    @Id @GeneratedValue
    private Long id;

    private String name; // 포지션(탑, 미드, 원딜, 정글, 서폿)
}

// 테이블로 관리할 것 인가?
// Enum을 이용해 관리할 것 인가? -> 데이터를 좀 더 보기 쉬움