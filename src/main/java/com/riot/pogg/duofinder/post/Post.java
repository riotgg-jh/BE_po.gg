package com.riot.pogg.duofinder.post;

import com.riot.pogg.duofinder.category.Category;
import com.riot.pogg.duofinder.position.Position;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String content; // 내용 (최대 80자)

    @Enumerated(EnumType.STRING)
    private PostStatus status; // 게시글 상태 (DRAFT, PUBLISHED, REJECTED)

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // 카테고리 연관 관계

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position; // 포지션 연관 관계

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성 시간

    @Column(nullable = false)
    private LocalDateTime expirationTime; // 만료 시간

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.expirationTime = createdAt.plusHours(24); // 기본 만료 시간 : 생성 후 24시간
    }
}
