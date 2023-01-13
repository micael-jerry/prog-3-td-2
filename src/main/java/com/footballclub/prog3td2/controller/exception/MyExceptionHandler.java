package com.footballclub.prog3td2.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> notFoundHandler(NotFoundException notFoundException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(404)
                .status(HttpStatus.NOT_FOUND)
                .message(notFoundException.getMessage())
                .build();
        return ResponseEntity
                .status(404)
                .body(apiResponse);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> badRequestHandler(BadRequestException badRequestException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(400)
                .status(HttpStatus.BAD_REQUEST)
                .message(badRequestException.getMessage())
                .build();
        return ResponseEntity
                .status(400)
                .body(apiResponse);
    }
}
