package com.riot.pogg.duofinder;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    private LocalDateTime createdAt = LocalDateTime.now(); //만료된 코드 삭제 부분

}


