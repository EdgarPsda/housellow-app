package com.psdadev.housellow.housellowapp.exceptions;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.psdadev.housellow.housellowapp.models.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorDto> handlerResourceNotFoundException(ResourceNotFoundException e){
    ErrorDto error = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ConversionFailedException.class)
  public ResponseEntity<ErrorDto> handlerConversionFailedException(ConversionFailedException e){
    ErrorDto error = ErrorDto.builder().message(e.getMessage()).build();
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorDto> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
    ErrorDto error = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationExceptions(
            MethodArgumentNotValidException e, WebRequest request) {
              @SuppressWarnings("null")
              ErrorDto error = ErrorDto.builder().code("400").message(e.getBindingResult().getFieldError().getDefaultMessage()).build();
              return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
