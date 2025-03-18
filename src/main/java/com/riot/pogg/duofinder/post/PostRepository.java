package com.riot.pogg.duofinder.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByExpirationTimeBefore(LocalDateTime now); // 만료된 게시글 조회
}
