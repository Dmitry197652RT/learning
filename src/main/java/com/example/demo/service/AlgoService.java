package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    // Дан массив чисел. Найти первое не повторяющееся число
    // {1, 2, 3, 4, 5, 1, 2, 4, 5} -> 3

    // идем по массиву O(n)
    // каждый элемент кладем в мапу в ходе прохода О(1)
    // пройти по ключам этой мапы и найти элемент значение которого равно 1 сложность О(n)

    // общая сложность O(n) + O(n) 2 = O(n)
    // особенности нотации и алгоритмической математики O(n) + O(n) = 2 * O(n) = O(n)
    // если элементов 100000 то будет 100000 вывода на печать.
    // 1) n элементов, для каждого элемента мы печатаем.
    // 100 -> 100 раз
    // 10000 -> 10000 раз
    // 2) n элементов, для каждого элемента мы проходим по массиву и ищем есть ли такой же. И каждый раз печатаем.
    // 100 -> 100 * 100 раз = 10000
    // 10000 -> 100000000 раз
    // 3) n элементов, для каждого элемента мы печатаем. Потом проходим еще раз и еще раз печатаем
    // 100 -> 200 раз
    // 10000 -> 20000 раз

    public int findNonrepeatedNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        // проверка длинны массива не равно 0
        // возможны 0 и отрицательные числа
        // дробные числа не пропустит контроллер, чарактеры тоже не пропустит контроллер
        // TODO реализовать на стримах
        // TODO придумать новые тестовые случаи например если несколько уникальных значений переделать
        //  метод под линендхешмап оценить сложность
        Map<Integer, Integer> map = new LinkedHashMap<>(); // создание мапы

        int countUnic = 0; // 2. Счетчик количества уникальных чисел (тех, что встретились 1 раз).
        int result = 0; // 3. Переменная для хранения самого уникального числа.
        int i = 0;
        while (i < numbers.length) {

            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
            i++;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                countUnic++;
                return entry.getKey();

                // запоминаем это число в result
            }
        }

        return result;

    }

    public List<Integer> findUniueNumbers(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new LinkedHashMap<>(); // создание мапы


        int i = 0;
        while (i < numbers.length) {

            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
            i++;
        }
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Integer findNonrepeatedNumberOnStream(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        Integer result = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(// метод вызывает обьект для создания мапы
                        Function.identity(),// метод сортирует ключи мапы
                        LinkedHashMap::new,// создается новый обьект линкедхашмап
                        Collectors.counting()))
                        .entrySet()
                .stream()
                .filter(entry ->entry.getKey() == 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Уникальные элементы не найдены!"))
                .getKey();;


        return result;

    }

    public boolean isNumber(int[] numbers){
        //  метод под линендхешмап оценить сложность

        return Arrays.stream(numbers)
                .allMatch(n -> n >=0 && n <=9);
    }

}
