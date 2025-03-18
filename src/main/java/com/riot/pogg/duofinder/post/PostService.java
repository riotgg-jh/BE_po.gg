package com.riot.pogg.duofinder.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void deleteExpiredPosts() {
        LocalDateTime now = LocalDateTime.now();
        List<Post> expiredPosts = postRepository.findByExpirationTimeBefore(now);

        if (!expiredPosts.isEmpty()) {
            postRepository.deleteAll(expiredPosts);
            System.out.println("만료된 게시글 삭제 완료: " + expiredPosts.size() + "개");
        }
    }
}
