package com.example.demo.controller;

import com.example.demo.dto.ErrorResponceDto;
import com.example.demo.dto.InvalidCharacterExceptionDto;
import com.example.demo.exceptions.InvalidCharacterException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.WrongNumberException;
import com.example.demo.model.MessageEntity;
import com.example.demo.service.AlgoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/controller")
public class AlgoController {
    public AlgoController(AlgoService algoService) {
        this.algoService = algoService;
    }

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
    public ResponseEntity<Boolean> isPerfect(@RequestParam int number) {
        return new ResponseEntity<>(algoService.isPerfect(number), HttpStatus.OK);
    }

    @PostMapping("/sumNumbers")
    public ResponseEntity<Long> sumNumbers(@RequestParam int[] numbers) {

        return new ResponseEntity<>(algoService.sumNumbers(numbers), HttpStatus.OK);
    }

    @PostMapping("/findnonrepeatednumber")
    public ResponseEntity<Integer> findNonRepeatedNumber(@RequestParam int[] numbers) {
        return new ResponseEntity<>(algoService.findNonrepeatedNumber(numbers), HttpStatus.OK);
    }

    @PostMapping("/findnonrepeatednumbers")
    public ResponseEntity<List<Integer>> findUniueNumbers(@RequestParam int[] numbers) {
        return new ResponseEntity<>(algoService.findUniueNumbers(numbers), HttpStatus.OK);
    }

    @PostMapping("/findnonrepeatednumberonstream")
    public ResponseEntity<Integer> findNonRepeatedNumberWithStream(@RequestParam int[] numbers) {
        if (algoService.findNonrepeatedNumberOnStream(numbers) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(algoService.findNonrepeatedNumber(numbers), HttpStatus.OK);
    }


    @PostMapping("/isPrime")
    public ResponseEntity<Boolean> isPrime(@RequestParam
                                           @Min(value = 2, message = "Number have to be more than 2")
                                           @Max(value = 1000)
                                           int sample) {

        return new ResponseEntity<>(algoService.isPrime(sample), HttpStatus.OK);

    }
// написать тесты и закоммитить
    //повторить checked uncheked и создание кастомных ошибок exception handler restcontroller advice

    //  На вход подается строка, содержащая различные скобки: (), {}, []. Нужно проверить,
    //  правильно ли они расставлены (каждой открывающей соответствует закрывающая, и порядок соблюдается).

    @PostMapping("/validbraket")
    public ResponseEntity<Boolean> isValidBrakets(@Valid @RequestParam String brakets) {
        if (!brakets.contains("(")) {
            throw new InvalidCharacterException("Not conatains any '(' )");
        }

        return new ResponseEntity<>(algoService.isValidDBraketswithStack(brakets), HttpStatus.OK);
    }

    @PostMapping("/v2/validbracket")
    public ResponseEntity<Boolean> isValidWithException(@RequestParam Character character) {

        if (character.equals('1')) {
            throw new NotFoundException("Number 1");

        }

        if (!Character.isAlphabetic(character)) {
            throw new WrongNumberException("Wrong number");
        }
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping("/results")
    public ResponseEntity<List<MessageEntity>> getAllresults(){

        return new ResponseEntity<>(algoService.findAllResults(), HttpStatus.OK);
    }
}

