package com.riot.pogg.duofinder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // 큐 타입과 포지션으로 게시글 필터링 작업
    List<Post> findByQueueTypeAndPosition(String queueType, String position);
}

