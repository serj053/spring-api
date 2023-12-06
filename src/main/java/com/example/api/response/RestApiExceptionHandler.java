package com.example.api.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//любой класс с аннотацией @ControllerAdvice является глобальным обработчиком
//исключений, который очень гибко настраивается.
@ControllerAdvice//объявили глобального обработчика исключений
public class RestApiExceptionHandler {
//    С помощью аннотации @ExceptionHandler можно обрабатывать исключения на уровне
//    отдельного контроллера. Для этого достаточно объявить метод, в котором будет
//    содержаться вся логика обработки нужного исключения (список обрабатываемых исключений
//    , и проаннотировать его.
    @ExceptionHandler(value={RestApiException.class})//будут перехвачены все исключения для RestapiException
    public ResponseEntity<Object> handleException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(e.getMessage() + " in handleException", status);
    }
}
