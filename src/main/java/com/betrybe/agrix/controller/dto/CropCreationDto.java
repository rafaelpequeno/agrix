package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;

/**
 * Implementa Dto para criação de plantação.
 *
 * @param name        Nome da plantação.
 * @param plantedArea Área da plantação.
 * @param farmId      "Id" da fazenda proprietária da plantação.
 */
public record CropCreationDto(String name, Double plantedArea, LocalDate plantedDate,
                              LocalDate harvestDate, Long farmId) {

  /**
   * Cria uma nova plantação com seus devidos atributos.
   *
   * @return Retorna uma plantação.
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
