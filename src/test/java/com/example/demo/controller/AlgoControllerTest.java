package com.example.demo.controller;

import com.example.demo.service.AlgoService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlgoController.class)
class AlgoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AlgoService algoService;

    @Test

    void isPerfect() throws Exception{
        given(algoService.isPerfect(6)).willReturn(true);

        // When & Then: выполняем POST с параметром и проверяем ответ
        mockMvc.perform(post("/api/controller/isPerfect")
                        .param("number", "6"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    void sumNumbers() {
    }

    @Test
    void findNonRepeatedNumber() {
    }

    @Test
    void findUniueNumbers() {
    }

    @Test
    void findNonRepeatedNumberWithStream() {
    }

    @Test
    void isPrime() {
    }

    @Test
    void isValidBrakets() {
    }

    @Test
    void isValidWithException() {
    }

    @Test
    void getAllresults() {
    }
}