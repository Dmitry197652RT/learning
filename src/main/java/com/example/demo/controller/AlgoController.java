package com.example.demo.controller;

import com.example.demo.service.AlgoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/controller")
@RequiredArgsConstructor
public class AlgoController {
    private final AlgoService algoService;
    /*
    Совершенное число — это положительное целое число,
    которое равно сумме его положительных делителей, не считая самого числа.
    Делитель целого числа x — это целое число, на которое x делится без остатка.
    Для заданного целого числа n верните true, если n — совершенное число, в противном случае верните false.
    Пример: 28 -> true (Делители числа 28: 1, 2, 4, 7, 14. 1+2+4+7+14=28)
    */
    // TODO проверить ли нечетные числа совершенные в пределах инта создать метод выявления нечетного числа
    //  среди совершенных чисел
    @PostMapping("/isPerfect")
    public ResponseEntity<Boolean> isPerfect(@RequestParam int number){
        return new ResponseEntity<>(algoService.isPerfect(number), HttpStatus.OK);
    }
    @PostMapping("/sumNumbers")
    public ResponseEntity<Long> sumNumbers(@RequestParam int[] numbers){

        return new ResponseEntity<>(algoService.sumNumbers(numbers), HttpStatus.OK);
    }
}
