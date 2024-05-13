package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;

/**
 * Implements the Crop creation DTO.
 *
 * @param name        The Crop name.
 * @param plantedArea The Crop planted area.
 * @param farmId      The identifier of the Farm entity to which the Crop belongs.
 */
public record CropCreationDto(String name, Double plantedArea, LocalDate plantedDate,
                              LocalDate harvestDate, Long farmId) {

  /**
   * Implements the Crop creation method with the given attributes.
   *
   * @return Return a new Crop.
   */
  public Crop toEntityWithoutFarm() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }
}
