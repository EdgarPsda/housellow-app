package com.psdadev.housellow.housellowapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.psdadev.housellow.housellowapp.exceptions.ResourceNotFoundException;
import com.psdadev.housellow.housellowapp.models.PropertyDto;
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

  // Find property by id
  public PropertyEntity findPropertyById(Long id){
    return propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found", "404", HttpStatus.NOT_FOUND));
  }

  // Save Property
  public PropertyEntity saveProperty(PropertyDto propertyDto){
    PropertyEntity propertyEntity = new PropertyEntity();
    propertyEntity.setAddress(propertyDto.getAddress());
    propertyEntity.setBathrooms(propertyDto.getBathrooms());
    propertyEntity.setBedrooms(propertyDto.getBedrooms());
    propertyEntity.setPrice(propertyDto.getPrice());
    propertyEntity.setSquareMeters(propertyDto.getSquareMeters());
    propertyEntity.setType(propertyDto.getType());
    return propertyRepository.save(propertyEntity);
  }

  // Update Property
  public PropertyEntity updateProperty(Long id, PropertyDto propertyDto){
    PropertyEntity propertyEntity = propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found", "404", HttpStatus.NOT_FOUND));
    propertyEntity.setAddress(propertyDto.getAddress());
    propertyEntity.setBathrooms(propertyDto.getBathrooms());
    propertyEntity.setBedrooms(propertyDto.getBedrooms());
    propertyEntity.setPrice(propertyDto.getPrice());
    propertyEntity.setSquareMeters(propertyDto.getSquareMeters());
    propertyEntity.setType(propertyDto.getType());
    return propertyRepository.save(propertyEntity);
  }

  // Delete Property
  @SuppressWarnings("null")
  public void deleteProperty(Long id){
    PropertyEntity propertyEntity = propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found", "404", HttpStatus.NOT_FOUND));
    propertyRepository.delete(propertyEntity);
  }

}
