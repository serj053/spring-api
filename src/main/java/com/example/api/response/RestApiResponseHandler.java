package com.example.api.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//любой класс с аннотацией @ControllerAdvice является глобальным обработчиком
//исключений, который очень гибко настраивается.
@ControllerAdvice//объявили глобального обработчика исключений
public class RestApiResponseHandler implements ResponseBodyAdvice<Object> {
//    С помощью аннотации @ExceptionHandler можно обрабатывать исключения на уровне
//    отдельного контроллера. Для этого достаточно объявить метод, в котором будет
//    содержаться вся логика обработки нужного исключения (список обрабатываемых исключений
//    , и проаннотировать его.
    //@ExceptionHandler(value={RestApiException.class})//будут перехвачены все исключения для RestapiException
    @ExceptionHandler()
    public ResponseEntity<Object> handleException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(e, status);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof Throwable){
            return new RestApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ((Throwable) body).getMessage() );
        }
        return new RestApiResponse(HttpStatus.OK.value(), "OK", body);
    }
}
