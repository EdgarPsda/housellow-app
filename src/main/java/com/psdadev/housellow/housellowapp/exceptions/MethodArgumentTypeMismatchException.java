package com.psdadev.housellow.housellowapp.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class MethodArgumentTypeMismatchException extends RuntimeException{

  private String code;
  private HttpStatus status;

  public MethodArgumentTypeMismatchException(String message, String code, HttpStatus status){
    super(message);
    this.code = code;
    this.status = status;
  }

}
