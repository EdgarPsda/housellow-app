package com.psdadev.housellow.housellowapp.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PropertyDto {

  @NotBlank(message = "Address is mandatory")
  private String address;

  @NotBlank(message = "Type is mandatory")
  private String type;

  @NotNull(message = "Price is mandatory")
  private Double price;

  @NotNull(message = "Bedrooms is mandatory")
  private Integer bedrooms;

  @NotNull(message = "Bathrooms is mandatory")
  private Integer bathrooms;

  @NotNull(message = "Square meters is mandatory")
  private Double squareMeters;
}
