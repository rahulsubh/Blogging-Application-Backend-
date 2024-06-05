package com.rahul.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;

    @NotBlank(message = "Min size of category title is 4")
    @Size(min = 4)
    private String categoryTitle;

    @NotBlank(message = "Min size of category description is 10")
    @Size(min = 10)
    private String categoryDescription;
}
