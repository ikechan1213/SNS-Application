package com.example.sns.repository;

import com.example.sns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//SpringDateJPAっていうのを使うとデータベースアクセスが楽になる

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
