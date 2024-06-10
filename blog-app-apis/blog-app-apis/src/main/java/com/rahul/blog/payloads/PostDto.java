package com.rahul.blog.payloads;

import com.rahul.blog.entities.Category;
import com.rahul.blog.entities.Comment;
import com.rahul.blog.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comments = new HashSet<>();


}
