package com.psdadev.housellow.housellowapp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

  private String code;
  private String message;

  public ErrorDto(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public ErrorDto() {
  }
}
