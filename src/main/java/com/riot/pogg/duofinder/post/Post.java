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

    @Column(nullable = false, length = 30)
    private String title; // 제목 (최대 30자)

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

    // JPA 기본 생성자
    public Post() {}

    // 게시글 생성 시간 설정 (JPA에서 자동 호출)
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    // 게시글을 승인(PUBLISHED) 상태로 변경
    public void approve() {
        if (this.status != PostStatus.DRAFT) {
            throw new IllegalStateException("게시물 승인");
        }
        this.status = PostStatus.PUBLISHED;
    }

    // 게시글을 거부(REJECTED) 상태로 변경
    public void reject() {
        if (this.status != PostStatus.DRAFT) {
            throw new IllegalStateException("게시물 거부");
        }
        this.status = PostStatus.REJECTED;
    }

}