package com.psdadev.housellow.housellowapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="properties")
public class PropertyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String type; // house, apartment, studio, etc

  @Column(nullable = false)
  private Double price; 

  @Column(nullable = false)
  private Integer bedrooms;

  @Column(nullable = false)
  private Integer bathrooms;

  @Column(nullable = false)
  private Double squareMeters;

  public PropertyEntity() {
  }

}
