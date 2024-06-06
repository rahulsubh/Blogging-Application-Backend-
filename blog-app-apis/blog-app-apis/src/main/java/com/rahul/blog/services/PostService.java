package com.rahul.blog.services;

import com.rahul.blog.entities.Post;
import com.rahul.blog.payloads.PostDto;
import com.rahul.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    //get single post
    PostDto getPostById(Integer postId);
    //get all posts by category
    PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
    //get all posts by User
    PostResponse getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize);
    //search posts
    List<PostDto> searchPosts(String keyword);


}
