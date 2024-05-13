package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * Implements the Farm DTO methods.
 *
 * @param id   The Farm entity identifier.
 * @param name The Farm entity name.
 * @param size The Farm entity size.
 */
public record FarmDto(Long id, String name, Double size) {

  /**
   * Implements the Farm Entity to DTO method.
   *
   * @param farm Farm entity.
   * @return Return a Farm DTO.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(), farm.getName(), farm.getSize()
    );
  }

  /**
   * Implements the Farm DTO to Entity method.
   *
   * @return Return a Farm entity.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setId(id);
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
