package com.example.demo.service;

import com.example.demo.model.MessageEntity;
import com.example.demo.repository.AlgoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AlgoService {


    private final AlgoRepository algoRepository;
     /*
    Совершенное число — это положительное целое число,
    которое равно сумме его положительных делителей, не считая самого числа.
    Делитель целого числа x — это целое число, на которое x делится без остатка.
    Для заданного целого числа n верните true, если n — совершенное число, в противном случае верните false.
    Пример: 28 -> true (Делители числа 28: 1, 2, 4, 7, 14. 1+2+4+7+14=28)
    */

    private static final String FIELD = "[]{}()";

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
        if (!isNumber(numbers)) {
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

        Map<Integer, Integer> map = new LinkedHashMap<>(); // создание мапы

        int countUnic = 0;
        int result = 0;
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

    public List<Integer> findUniueNumbers(int[] numbers) {
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

    public Integer findNonrepeatedNumberOnStream(int[] numbers) {
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
                .filter(entry -> entry.getKey() == 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Уникальные элементы не найдены!"))
                .getKey();


        return result;

    }

    public boolean isNumber(int[] numbers) {

        return Arrays.stream(numbers)
                .allMatch(n -> n >= 0 && n <= 9);
    }
    @Transactional
    public boolean isPrime(int sample) {
        boolean flag = true;
        //если остаток от деления числа равен нулю значит деление произошло
        //делитель не должен быть единицей и самим числом
        for (int i = 2; i < sample - 1; i++) {
            if (sample % i == 0) {
                flag = false;
                break;
            };
        }
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setResult(String.valueOf(flag));
        messageEntity.setCreatedAt(LocalDateTime.now());
        algoRepository.save(messageEntity);


        return flag;
    }

    public List<MessageEntity> findAllResults(){

        return algoRepository.findAll();
    }
    // На вход подается строка, содержащая различные скобки: (), {}, []. Нужно проверить,
    // правильно ли они расставлены (каждой открывающей соответствует закрывающая, и порядок соблюдается).
    public boolean isValidDBrakets(String source) {

        // TODO использовать стрингбилдер
        // оценить сложность алгоритма
        // придумать алгоритм который восприимчив к трем типам скобок
        // использовать stack ( -> кладем в стэк каждого типа скобок
        if (source.charAt(0) == ')') {
            return false;
        }
        while (true) {
            if ("".equals(source)) {
                return true;
            }
            if (source.contains("()")) {
                source = source.replace("()", "");
            } else return false;
            System.out.println(source);
        }

    }

    public boolean isValidDBraketswithCase(String source) {

        if (source.charAt(0) == ')') {
            return false;
        }
        if (source.charAt(0) == '}') {
            return false;
        }
        if (source.charAt(0) == ']') {
            return false;
        }

        if (source.length() % 2 != 0) return false;

        int round = 0, square = 0, curly = 0;


        for (char c : source.toCharArray()) {

            switch (c) {
                case '(':
                    round++;
                    break;
                case ')':
                    round--;
                    break;
                case '[':
                    square++;
                    break;
                case ']':
                    square--;
                    break;
                case '{':
                    curly++;
                    break;
                case '}':
                    curly--;
                    break;
            }


        }
        if (round < 0 || square < 0 || curly < 0) {
            System.out.println("Некомплектная скобка");
            return false;
        }

        return true;
    }


    public boolean isValidDBraketswithStack(String source) {
        Stack<Character> roundBrackets = new Stack<>();
        Stack<Character> squareBrackets = new Stack<>();
        Stack<Character> figureBrackets = new Stack<>();
        if (source.charAt(0) == ')') {
            return false;
        }
        if (source.charAt(0) == '}') {
            return false;
        }
        if (source.charAt(0) == ']') {
            return false;
        }
        if (source.length() % 2 != 0) return false;



        for (int i = 0; i < source.length(); i++) {
            if(FIELD.contains(Character.toString(source.charAt(i)))){
               throw new IllegalArgumentException("Exception");
            }

            if (source.charAt(i) == '(') {
                roundBrackets.push(source.charAt(i));
            } else if (source.charAt(i) == ')') {
                // Если закрывающая — проверяем, есть ли для нее пара
                if (roundBrackets.isEmpty()) {
                    return false;
                }
                roundBrackets.pop();
            }
                if (source.charAt(i) == '{') {
                    figureBrackets.push(source.charAt(i));
                } else if (source.charAt(i) == '}') {
                    if (figureBrackets.isEmpty()) {
                        return false;
                    }
                    figureBrackets.pop();

                    if (source.charAt(i) == '[') {
                        squareBrackets.push(source.charAt(i));
                    } else if (source.charAt(i) == ']') {
                        if (figureBrackets.isEmpty()) {
                            return false;
                        }
                        squareBrackets.pop();
                    }
                }

        }
        return roundBrackets.isEmpty() && squareBrackets.isEmpty() && figureBrackets.isEmpty();
    }
}