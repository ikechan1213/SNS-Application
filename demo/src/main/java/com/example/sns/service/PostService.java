package com.example.sns.service;

import com.example.sns.domain.Post;
import com.example.sns.domain.User;
import com.example.sns.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//投稿の作成、取得、ユーザーごとの投稿一覧を取得するロジック

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(User user, String content) {
        Post post = new Post();
        post.setUser(user);
        post.setContent(content);
        return postRepository.save(post);
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostsByUserId(User user) {
        return postRepository.findByUser(user);
    }
}

