package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AlgoService {
     /*
    Совершенное число — это положительное целое число,
    которое равно сумме его положительных делителей, не считая самого числа.
    Делитель целого числа x — это целое число, на которое x делится без остатка.
    Для заданного целого числа n верните true, если n — совершенное число, в противном случае верните false.
    Пример: 28 -> true (Делители числа 28: 1, 2, 4, 7, 14. 1+2+4+7+14=28)
    */

    public boolean isPerfect(int number){
        if(number <= 1) {return false;}
        //создание переменной, в которую суммируются делители. Как только эта переменная становится равной
        // числу задача завершается с положительным результатом. если переменная превышает число задача
        // завершается с отрицательным результатом.
        // по времени n по памяти 1
        int devidersSum = 0;
        for(int i = 1; i < number; i++) {
            if(number % i == 0 ) {
                devidersSum += i;
            }
        }
        return devidersSum == number;
    }
}
