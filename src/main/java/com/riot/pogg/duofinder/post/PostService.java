package com.riot.pogg.duofinder.post;

import com.riot.pogg.duofinder.category.Category;
import com.riot.pogg.duofinder.category.CategoryRepository;
import com.riot.pogg.duofinder.position.Position;
import com.riot.pogg.duofinder.position.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final PositionRepository positionRepository;

    public PostService(PostRepository postRepository,
                       CategoryRepository categoryRepository,
                       PositionRepository positionRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.positionRepository = positionRepository;
    }

    public void createPost(PostRequestDTO postRequestDTO) {
        // 카테고리 및 포지션 조회
        Category category = categoryRepository.findById(Long.parseLong(postRequestDTO.getCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        Position position = positionRepository.findById(Long.parseLong(postRequestDTO.getPositionId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid position ID"));

        // Post 엔티티 생성 및 저장
        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());
        post.setCategory(category);
        post.setPosition(position);
        post.setStatus(PostStatus.DRAFT); // 초기 상태는 DRAFT

        postRepository.save(post);
    }
}
