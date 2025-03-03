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

