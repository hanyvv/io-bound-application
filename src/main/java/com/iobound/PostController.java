package com.iobound;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private static Integer PAGE_SIZE = 20;

    private final PostRepository postRepository;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public Page<Post> getPostList(@RequestParam(defaultValue = "1") Integer page) {
        return postRepository.findAll(
                PageRequest.of(page - 1, PAGE_SIZE, Sort.by("id").descending())
        );
    }
}
