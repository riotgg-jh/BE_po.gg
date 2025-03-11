package com.riot.pogg.duofinder.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@Validated @RequestBody PostRequestDTO postRequestDTO) {
        postService.createPost(postRequestDTO);
        return new ResponseEntity<>("게시글이 등록이 완료되었습니다.", HttpStatus.CREATED);
    }
}
