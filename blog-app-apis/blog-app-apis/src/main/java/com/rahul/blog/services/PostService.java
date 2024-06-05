package com.rahul.blog.services;

import com.rahul.blog.entities.Post;
import com.rahul.blog.payloads.PostDto;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
    //update
    Post updatePost(PostDto postDto);
    //delete
    void deletePost(Integer postId);
    //get all posts
    List<Post> getAllPost();
    //get single post
    Post getPostById(Integer postId);
    //get all posts by category
    List<Post> getPostByCategory(Integer categoryId);
    //get all posts by User
    List<Post> getPostsByUser(Integer userId);


}
