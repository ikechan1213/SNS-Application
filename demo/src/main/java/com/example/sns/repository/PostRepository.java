package com.example.sns.repository;

import com.example.sns.domain.Post;
import com.example.sns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
}
