package com.rahul.blog.controllers;

import com.rahul.blog.entities.Post;
import com.rahul.blog.payloads.ApiResponse;
import com.rahul.blog.payloads.PostDto;
import com.rahul.blog.payloads.PostResponse;
import com.rahul.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){

        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);

    }
    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostsByUser(
            @PathVariable Integer userId,
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
            ){
        PostResponse postResponse = this.postService.getPostsByUser(userId, pageNumber, pageSize);
        return ResponseEntity.ok(postResponse);
    }
    //get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostsByCategory(
            @PathVariable Integer categoryId,
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
            ){
        PostResponse postResponse = this.postService.getPostByCategory(categoryId, pageNumber, pageSize);
        return ResponseEntity.ok(postResponse);
    }
    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = "postId",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "ASC",required = false) String sortDir
    ){
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(postResponse);
    }
    //get single post
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
        PostDto post = this.postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }
    //delete post
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted Successfully",true),HttpStatus.OK);
    }
    //update post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(
            @RequestBody PostDto postDto,
            @PathVariable Integer postId
    ){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return ResponseEntity.ok(updatePost);
    }
}
