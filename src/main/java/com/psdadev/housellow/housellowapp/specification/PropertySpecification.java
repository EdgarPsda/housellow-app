package com.psdadev.housellow.housellowapp.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.psdadev.housellow.housellowapp.models.PropertyEntity;

import jakarta.persistence.criteria.Predicate;

public class PropertySpecification {

  public static Specification<PropertyEntity> withDynamicQuery(String type, Integer minBedrooms, Integer maxPrice, Integer minBathrooms, Double maxSquareMeters){
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (type != null){
        predicates.add(criteriaBuilder.equal(root.get("type"), type));
      }

      if(minBedrooms != null){
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("bedrooms"), minBedrooms));
      }

      if(maxPrice != null){
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
      }

      if(minBathrooms != null){
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("bathrooms"), minBathrooms));
      }

      if(maxSquareMeters != null){
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("squareMeters"), maxSquareMeters));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }

}
