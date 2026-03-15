package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserPostDto {
    Integer id;
    Integer userId;
    String title;
    String body;
}
