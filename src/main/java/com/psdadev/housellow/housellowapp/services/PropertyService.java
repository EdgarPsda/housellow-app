package com.psdadev.housellow.housellowapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.psdadev.housellow.housellowapp.exceptions.ResourceNotFoundException;
import com.psdadev.housellow.housellowapp.models.PropertyEntity;
import com.psdadev.housellow.housellowapp.repositories.PropertyRepository;

@Service
public class PropertyService{

  @Autowired
  private PropertyRepository propertyRepository;

  // List all properties
  public List<PropertyEntity> findAllProperties(){
    List<PropertyEntity> result = propertyRepository.findAll();
    if(result.isEmpty()){
      throw new ResourceNotFoundException("No properties found", "404", HttpStatus.NOT_FOUND);
    }
    return result;
  }

}
