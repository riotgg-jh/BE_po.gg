package com.riot.pogg.duofinder.post;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PostScheduler {

    private final PostService postService;

    public PostScheduler(PostService postService) {
        this.postService = postService;
    }

    @Scheduled(cron = "0 0 0 * * *") // 자정 실행
    public void removeExpiredPosts() {
        postService.deleteExpiredPosts();
        System.out.println("스케줄링 실행: 만료된 게시글 삭제 완료");
    }
}
