package com.psdadev.housellow.housellowapp.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

  private String code;
  private HttpStatus status;

  public ResourceNotFoundException(String message, String code, HttpStatus status){
    super(message);
    this.code = code;
    this.status = status;
  }

}
