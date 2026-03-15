package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


public record CommentDTO(
        int postId,
        int id,
        String name,
        String email,
        String body) {


}
