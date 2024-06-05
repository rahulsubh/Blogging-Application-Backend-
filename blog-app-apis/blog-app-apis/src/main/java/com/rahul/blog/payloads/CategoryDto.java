package com.rahul.blog.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
