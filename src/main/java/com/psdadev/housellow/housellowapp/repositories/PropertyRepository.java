package com.psdadev.housellow.housellowapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.psdadev.housellow.housellowapp.models.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long>, JpaSpecificationExecutor<PropertyEntity>{

  // List all properties
  @SuppressWarnings("null")
  List<PropertyEntity> findAll();

  // Find property by id
  @SuppressWarnings("null")
  Optional<PropertyEntity> findById(Long id);

  // Save Property
  @SuppressWarnings({ "null", "unchecked" })
  PropertyEntity save(PropertyEntity propertyEntity);

  // Delete Property
  @SuppressWarnings("null")
  void deleteById(Long id);

  // Get properties in a price range
  List<PropertyEntity> findByPriceBetween(Double min, Double max);
}
