package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.JsonPlaceHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jsonplaceholder")
@RequiredArgsConstructor
public class JsonPlaceholderController {

    private final JsonPlaceHolderService jsonPlaceHolderService;

    @GetMapping("/title/{id}")
    public ResponseEntity<String> getPlaceholderTitle(@PathVariable int id)
    {

        return new ResponseEntity(jsonPlaceHolderService.getTitleFromPost(id), HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<List<CommentDTO>> getCommentsbyPostId(@PathVariable int id){

        return  new ResponseEntity<>(jsonPlaceHolderService.getComments(id), HttpStatus.OK);
    }
    // имя базы логин пароль сохранить
}
