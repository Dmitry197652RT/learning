package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;


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

    public boolean isPerfect(int number) {
        if (number <= 1 || number % 2 != 0) {
            return false;
        }
        //создание переменной, в которую суммируются делители. Как только эта переменная становится равной
        // числу задача завершается с положительным результатом. если переменная превышает число задача
        // завершается с отрицательным результатом.
        // по времени n по памяти 1
        int devidersSum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                devidersSum += i;
            }
        }
        return devidersSum == number;
    }


    //Дан массив. Вывести число, равное максимальному количеству повторений какого-либо числа в массиве.
    // [1,2,2,3,,4,4,4,5,5 ] -> 3 (число 4 встречается 3 раза)
    //TODO написать контроллер и сервис выгрузить на гитхаб
    // 2 внедрить зависимости для тестирования юнит5
    // мокито

    public long sumNumbers(int[] numbers) {

        if (numbers == null) {
            throw new NullPointerException("Numbers is null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException(" Numbers id empty");

        }
        if(!isNumber(numbers)){
            throw new IllegalArgumentException("Arguments are not numbers");
        }

        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .max(Long::compare)
                .orElse(0L);


    }

    public boolean isNumber(int[] numbers){

        return Arrays.stream(numbers)
                .allMatch(n -> n >=0 && n <=9);
    }

}
