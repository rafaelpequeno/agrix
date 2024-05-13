package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Fertilizer;
import java.util.List;

/**
 * Implements the Fertilizer DTO methods.
 *
 * @param id          The Fertilizer entity identifier.
 * @param name        The Fertilizer entity name.
 * @param brand       The Fertilizer entity brand.
 * @param composition The Fertilizer entity composition.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {

  /**
   * Implements the Fertilizer entity to DTO method.
   *
   * @param fertilizer The Fertilizer entity.
   * @return Return a Fertilizer DTO.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(fertilizer.getId(), fertilizer.getName(), fertilizer.getBrand(),
        fertilizer.getComposition());
  }

  /**
   * Implements the Fertilizer DTO to entity method.
   *
   * @return Return a Fertilizer entity.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setId(id);
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }

  /**
   * Implements the method which transforms a list of Fertilizer entities into a list of Fertilizer
   * DTOs.
   *
   * @param fertilizers A list of Fertilizer entities.
   * @return Return a list of Fertilizer DTOs.
   */
  public static List<FertilizerDto> fromEntities(List<Fertilizer> fertilizers) {
    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

}
