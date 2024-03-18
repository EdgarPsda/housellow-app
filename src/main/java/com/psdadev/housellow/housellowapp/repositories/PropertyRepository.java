package com.psdadev.housellow.housellowapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psdadev.housellow.housellowapp.models.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long>{

  // List all properties
  @SuppressWarnings("null")
  List<PropertyEntity> findAll();

}
