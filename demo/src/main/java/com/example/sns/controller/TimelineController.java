package com.example.sns.controller;

import com.example.sns.domain.Post;
import com.example.sns.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TimelineController {

    private final PostService postService;

    public TimelineController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/timeline")
    public String getTimeline(Model model) {
        // 全ての投稿を取得
        List<Post> posts = postService.getAllPosts();

        // 投稿リストをJSPに渡す
        model.addAttribute("posts", posts);

        // timeline.jspを返す
        return "timeline";
    }
}
