package com.riot.pogg.duofinder.category;

import com.riot.pogg.duofinder.post.Post;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // DB에 문자열 형태로 저장
    private CategoryType categoryType;

    @OneToMany(mappedBy = "category")
    private List<Post> posts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

