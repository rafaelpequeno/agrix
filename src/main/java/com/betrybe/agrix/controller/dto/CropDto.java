package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;

/**
 * Implements the Crop DTO methods.
 *
 * @param id          The Crop Entity identifier.
 * @param name        The Crop Entity name.
 * @param plantedArea The Crop Entity planted area.
 * @param plantedDate The Crop Entity planted date.
 * @param harvestDate The Crop Entity harvest date.
 * @param farmId      The identifier of the Farm entity to which the Crop belongs.
 */
public record CropDto(Long id, String name, Double plantedArea, LocalDate plantedDate,
                      LocalDate harvestDate, Long farmId) {

  /**
   * Implements the Entity to DTO method.
   *
   * @param crop The Crop entity.
   * @return Return a Crop DTO.
   */
  public static CropDto fromEntity(Crop crop) {
    return
        new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getPlantedDate(),
            crop.getHarvestDate(), crop.getFarm().getId());
  }

  /**
   * Implements the DTO to Entity method.
   *
   * @return Return a Crop entity.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setId(id);
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }
}
