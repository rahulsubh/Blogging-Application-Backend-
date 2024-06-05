package com.rahul.blog.repositories;

import com.rahul.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
