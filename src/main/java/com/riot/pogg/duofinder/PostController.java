package com.riot.pogg.duofinder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/category/{categoryName}")
    public List<Post> getPostsByCategory(@PathVariable String categoryName) {
        return postService.getPostsByCategory(categoryName);
    }

    @GetMapping("/position/{positionName}")
    public List<Post> getPostsByPosition(@PathVariable String positionName) {
        return postService.getPostsByPosition(positionName);
    }

    @PostMapping("/")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}

