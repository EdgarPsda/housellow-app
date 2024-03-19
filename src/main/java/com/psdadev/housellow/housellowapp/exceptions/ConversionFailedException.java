package com.psdadev.housellow.housellowapp.exceptions;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ConversionFailedException extends RuntimeException{
  private HttpStatus status;

  public ConversionFailedException(String message, HttpStatus status){
    super(message);
    this.status = status;
  }
}
