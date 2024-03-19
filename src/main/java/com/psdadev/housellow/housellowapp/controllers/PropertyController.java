package com.psdadev.housellow.housellowapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.psdadev.housellow.housellowapp.models.PropertyDto;
import com.psdadev.housellow.housellowapp.models.PropertyEntity;
import com.psdadev.housellow.housellowapp.services.PropertyService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class PropertyController {

  @Autowired
  private PropertyService propertyService;

  @GetMapping("/properties")
  public ResponseEntity<List<PropertyEntity>> getAllProperties() {
    return ResponseEntity.ok(propertyService.findAllProperties());
  }

  @GetMapping("/properties/{id}")
  public ResponseEntity<PropertyEntity> getProperty(@PathVariable Long id){
    return ResponseEntity.ok(propertyService.findPropertyById(id));
  }

  @PostMapping("/properties")
  public ResponseEntity<PropertyEntity> createProperty(@Valid @RequestBody PropertyDto propertyDto ){
    return ResponseEntity.ok(propertyService.saveProperty(propertyDto));
  }
  
  @PutMapping("/properties/{id}")
  public ResponseEntity<PropertyEntity> updateProperty(@PathVariable Long id, @Valid @RequestBody PropertyDto propertyDto){
    return ResponseEntity.ok(propertyService.updateProperty(id, propertyDto));
  }

  @DeleteMapping("/properties/{id}")
  public ResponseEntity<String> deleteProperty(@PathVariable Long id){
    propertyService.deleteProperty(id);
    return ResponseEntity.ok("Property deleted");
  }
}
