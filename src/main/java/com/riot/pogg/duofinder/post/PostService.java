package com.riot.pogg.duofinder.post;

import com.riot.pogg.duofinder.category.Category;
import com.riot.pogg.duofinder.position.Position;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final RiotApiService riotApiService;

    public PostService(PostRepository postRepository, RiotApiService riotApiService) {
        this.postRepository = postRepository;
        this.riotApiService = riotApiService;
    }

    @Transactional
    public void createPost(PostRequestDTO postRequestDTO) {
        // 소환사 이름 검증 (Riot API)
        if (!riotApiService.isSummonerNameValid(postRequestDTO.getContent())) {
            throw new IllegalArgumentException("입력한 소환사 이름이 존재하지 않습니다.");
        }

        Category category = new Category();
        category.setId(Long.parseLong(postRequestDTO.getCategoryId()));

        Position position = new Position();
        position.setId(Long.parseLong(postRequestDTO.getPositionId()));

        Post post = new Post();
        post.setContent(postRequestDTO.getContent());
        post.setCategory(category);
        post.setPosition(position);
        post.setStatus(PostStatus.PUBLISHED);

        postRepository.save(post);
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
