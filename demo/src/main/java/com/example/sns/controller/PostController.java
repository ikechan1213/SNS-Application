package com.example.sns.controller;

import com.example.sns.domain.Post;
import com.example.sns.domain.User;
import com.example.sns.service.PostService;
import com.example.sns.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserRepository userRepository;

    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    private Optional<User> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            return userRepository.findByEmail(auth.getName());
        }
        return Optional.empty();
    }

    // 投稿を作成するAPI
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody String content) {
        Optional<User> currentUser = getCurrentUser();
        if (currentUser.isPresent()) {
            User user = currentUser.get();
            Post post = postService.createPost(user, content);
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        //「.orElse(ResponseEntity.status(401).body("Unauthorized"));」のorElseからif-else文に変更
    }

    // 特定の投稿を取得するAPI
    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ログインユーザーの投稿一覧を取得するAPI
    @GetMapping("/me")
    public ResponseEntity<?> getMyPosts() {
        Optional<User> currentUser = getCurrentUser();
        if (currentUser.isPresent()) {
            User user = currentUser.get();
            List<Post> posts = postService.getPostsByUserId(user);
            return ResponseEntity.ok(posts);
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }
}