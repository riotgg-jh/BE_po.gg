package com.riot.pogg.duofinder.post;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PostScheduler {

    private final PostService postService;

    public PostScheduler(PostService postService) {
        this.postService = postService;
    }

    // 매일 자정에 실행 (CRON 표현식: 초 분 시 일 월 요일)
    @Scheduled(cron = "0 0 0 * * *")
    public void removeExpiredPosts() {
        postService.deleteExpiredPosts();
        System.out.println("스케줄링 실행: 만료된 게시글 삭제 작업 완료");
    }
}
