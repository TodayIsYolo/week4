package com.example.myblogs.controller;





import com.example.myblogs.domain.Comment;
import com.example.myblogs.dto.CommentRequestDto;
import com.example.myblogs.repository.CommentRepository;
import com.example.myblogs.security.UserDetailsImpl;
import com.example.myblogs.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    //코멘트 보여주기
    @GetMapping("/blogs/{id}/comments")
    public List<Comment> getComments(@PathVariable("id") Long blogId) {
        //게시글 번호로 코멘트를 조회해서 해당하는 코멘트만 리턴
        return commentRepository.findByBlogIdOrderByModifiedAtDesc(blogId);
    }

    //코멘트 생성
    @PostMapping("/api/blogs/{id}/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        //생성시 생성자의 아이디를 받아 함께 저장
        //게시글 아이디는 commentRequestDto에 있음 만들당시 잘 몰라서 여러방식으로 저장함
        Long userId = userDetails.getUser().getId();
        String username = userDetails.getUsername();
        Comment comment = new Comment(commentRequestDto,userId, username);
        return commentRepository.save(comment);
    }

    //코멘트 수정
    @PutMapping("/api/blogs/{blogId}/comments/{commentId}")
    public Long updateComments(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto){
        commentService.updateComment(commentId, requestDto);
        return commentId;
    }

    //코멘트 삭제
    @DeleteMapping("/api/blogs/{blogId}/comments/{commentId}")
    public  String deleteComment(@PathVariable Long commentId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        //삭제시 삭제자의 이름과 생성자의이름을 비교해 같으면 삭제 성공하도록 만들었는데 앞단에서 생성자,삭제자의 이름이 다르면 아예 버튼이 안보이도록 만들어서
        //필요없어짐
        String name = userDetails.getUser().getUsername();
        String commentUserName = commentRepository.findById(commentId).get().getUsername();
        if (Objects.equals(name, commentUserName)){
            commentRepository.deleteById(commentId);
        } else {
            return "삭제실패";
        }
        return "삭제성공";
    }
}

