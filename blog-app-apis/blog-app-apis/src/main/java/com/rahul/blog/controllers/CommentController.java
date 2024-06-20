package com.rahul.blog.controllers;

import com.rahul.blog.payloads.ApiResponse;
import com.rahul.blog.payloads.CommentDto;
import com.rahul.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @PathVariable Integer postId
    ){
        CommentDto comment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(
            @PathVariable Integer commentId
    ){
        this.commentService.deleteComment(commentId);
        return ResponseEntity.ok(new ApiResponse("Comment deleted Successfully!!",true));
    }
}
