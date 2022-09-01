package com.springboot.blog.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10, message = "Body should have at least 10 characters")
    private String body;
}
