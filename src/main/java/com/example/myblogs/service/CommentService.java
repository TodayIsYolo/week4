package com.example.myblogs.service;

import com.example.myblogs.domain.Comment;
import com.example.myblogs.dto.CommentRequestDto;
import com.example.myblogs.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void updateComment(Long commentId, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.updateComment(requestDto);
    }
}

