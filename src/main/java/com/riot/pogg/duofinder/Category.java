package com.riot.pogg.duofinder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 큐 타입(솔로 랭크, 자유 랭크, 일반 게임)

    @OneToMany(mappedBy = "category")
    private List<Post> posts = new ArrayList<>();

}

