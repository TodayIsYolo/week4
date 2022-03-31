package com.example.myblogs.service;


import com.example.myblogs.domain.Blog;
import com.example.myblogs.dto.BlogRequestDto;
import com.example.myblogs.repository.BlogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Transactional // 디비에 반영 필요 알려주기
    public void update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
    }
}