package com.rahul.blog.repositories;

import com.rahul.blog.entities.Category;
import com.rahul.blog.entities.Post;
import com.rahul.blog.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
//    List<Post> findByUser(User user);
    Page<Post> findByUser(User user, Pageable pageable);
//    List<Post> findByCategory(Category category);
    Page<Post> findByCategory(Category category, Pageable pageable);
}
