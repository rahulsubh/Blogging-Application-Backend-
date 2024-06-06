package com.rahul.blog.services;

import com.rahul.blog.entities.Post;
import com.rahul.blog.payloads.PostDto;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
    List<PostDto> getAllPost();
    //get single post
    PostDto getPostById(Integer postId);
    //get all posts by category
    List<PostDto> getPostByCategory(Integer categoryId);
    //get all posts by User
    List<PostDto> getPostsByUser(Integer userId);


}
