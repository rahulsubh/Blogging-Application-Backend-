package com.rahul.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int id;

//    @NotEmpty(message = "Username is Required !!")
    @Size(min = 4, message = "Username must be min of 4 characters")
    private String name;

    @Email(message = "Email address is not valid !!")
    @NotEmpty(message = "Email is required !!")
    private String email;

    @NotEmpty
    @Size(min = 3,max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
    private String password;

    @NotEmpty(message = "About is Required !!")
    private String about;

    private Set<RoleDto> roles = new HashSet<>();
}
