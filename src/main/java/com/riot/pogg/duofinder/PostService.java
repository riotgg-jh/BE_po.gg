package com.riot.pogg.duofinder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPostsByCategory(String categoryName) {
        return postRepository.findByCategoryName(categoryName);
    }

    public List<Post> getPostsByPosition(String positionName) {
        return postRepository.findByPositionName(positionName);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}


