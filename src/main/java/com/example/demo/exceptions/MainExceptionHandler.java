package com.example.demo.exceptions;

import com.example.demo.dto.ErrorResponceDto;
import com.example.demo.dto.ExtendedExceptionDto;
import com.example.demo.dto.InvalidCharacterExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(WrongNumberException.class)
    public ResponseEntity<ErrorResponceDto> handleException() {
        ErrorResponceDto errorResponceDto = new ErrorResponceDto();
        errorResponceDto.setMessage("Wrong character");

        return new ResponseEntity<>(errorResponceDto, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InvalidCharacterException.class)
    public ResponseEntity<InvalidCharacterExceptionDto> handleStringException() {
        InvalidCharacterExceptionDto invalidCharacterExceptionDto = new InvalidCharacterExceptionDto();
        invalidCharacterExceptionDto.setMessage("Not conatains any '(' )");

        return new ResponseEntity<>(invalidCharacterExceptionDto, HttpStatus.BAD_REQUEST);

    }
// найти и запомнить принципы рест стайтлесс нельзя ссылаться на другие запросы. вся информация сразу
    // единообразный стиль устоявшиеся правила тот кто делает запросы должен интуитивно понимать какой
// метод что делает
    // кэшируемость запросов на стороне сервера
    // принцип слоеных запросов апи может быть сложным но пользователь не должен это видеть.
    // рест - отвечает на вопрос ЧТО - получаем состояние обьекта, получаем джсон. РПС - что сделать, вызов
// метода, в идеале надо давать обратную связь о выполнении методов.
    // в целом надо избегать войд методов. метод должен вернуть ответ о выполнении
    //асинхронные методы для брокеров сообщений - неблокирующие.
    // реактивные тоже неблокирующие по сути дела это асинхронный рест

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExtendedExceptionDto> handleNotfoundException(NotFoundException exception) {

        ExtendedExceptionDto errorBody = new ExtendedExceptionDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found",
                exception.getMessage()
        );

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }
}
