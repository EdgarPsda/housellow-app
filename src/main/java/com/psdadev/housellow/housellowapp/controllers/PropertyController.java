package com.psdadev.housellow.housellowapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.psdadev.housellow.housellowapp.models.PropertyEntity;
import com.psdadev.housellow.housellowapp.services.PropertyService;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1")
public class PropertyController {

  @Autowired
  private PropertyService propertyService;

  @GetMapping("/properties")
  public ResponseEntity<List<PropertyEntity>> getAllProperties() {
    return ResponseEntity.ok(propertyService.findAllProperties());
  }
  

}
