package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.UserPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JsonPlaceHolderService {

    private final RestClient restClient;

    public String getTitleFromPost(int id){

        UserPostDto userPostDto = restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(UserPostDto.class);
// добавить проверки на налл
        return userPostDto.getTitle();
    }
    public List<CommentDTO> getComments(int postId){

        CommentDTO[] commentDTOS =  restClient.get()
                .uri("posts/{postId}/comments", postId)
                .retrieve()
                .body(CommentDTO[].class);

        return Arrays.asList(commentDTOS);
    }


}
