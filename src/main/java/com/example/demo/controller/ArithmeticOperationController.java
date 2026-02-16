package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/operation")
public class ArithmeticOperationController {
    // TODO изучитьвозврат респонсеэнтити

    //TODO переписать на пост
    @GetMapping("/v1/maxsquare")
    public long getMaxSquare(){
        int[] sample = {3, 5, 7, 8, 9, -100};
        if (sample == null || sample.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int[] sample2 = Arrays.stream(Objects.requireNonNull(sample, "Массив не может быть null"))
                .mapToObj(s -> String.valueOf(s))
                .mapToInt(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Некорректный элемент '" + s + "': ожидалось целое число");
                    }
                })
                .toArray();


        if (sample2.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        //TODO проверить на пустой массив, правильные символы или дроби
        long maxSquare = 0;
        for(int i = 0; i < sample.length; i++){
            int tmp = sample[i] * sample[i];
            maxSquare = tmp;
            if(tmp > maxSquare) maxSquare = tmp;
        }

        return maxSquare;
    }

    @GetMapping("/v1/square/{num}")
    public int getSquare(@PathVariable int num){

        return num * num;
    }
    @GetMapping("/v1/cube")
    public int getCube(@RequestParam int num){

        return num * num * num;
    }
    //TODO модифицировать метод так, что бы он принимал любое количество чисел до пяти штук и их умножал
    @GetMapping("/v1/production")
    public int getProduction(@RequestParam(required = false) List<Integer> nums){

        return nums.stream()
                .limit(5)
                .reduce(1, (a, b) -> a * b);
    }
    @PostMapping("/v2/maxsquare")
    public long postMaxSquare(){
        int[] sample = {3, 5, 7, 8, 9, -100};
        if (sample == null || sample.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int[] sample2 = Arrays.stream(Objects.requireNonNull(sample, "Массив не может быть null"))
                .mapToObj(s -> String.valueOf(s))
                .mapToInt(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Некорректный элемент '" + s + "': ожидалось целое число");
                    }
                })
                .toArray();


        if (sample2.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        //TODO проверить на пустой массив, правильные символы или дроби
        long maxSquare = 0;
        for(int i = 0; i < sample.length; i++){
            int tmp = sample[i] * sample[i];
            maxSquare = tmp;
            if(tmp > maxSquare) maxSquare = tmp;
        }

        return maxSquare;
    }
}
