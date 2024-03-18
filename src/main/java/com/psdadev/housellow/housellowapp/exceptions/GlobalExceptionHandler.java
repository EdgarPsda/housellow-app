package com.psdadev.housellow.housellowapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.psdadev.housellow.housellowapp.models.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorDto> handlerResourceNotFoundException(ResourceNotFoundException e){
    ErrorDto error = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

}
