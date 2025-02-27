package com.riot.pogg.duofinder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> filterPostsByQueueAndPosition(String queueType, String position) {
        return postRepository.findByQueueTypeAndPosition(queueType, position);
    }
}

