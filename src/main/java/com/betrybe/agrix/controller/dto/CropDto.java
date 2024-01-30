package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;

/**
 * Implementa Dto da plantação.
 *
 * @param id          "Id" da planatação.
 * @param name        nome da plantação.
 * @param plantedArea área total da plantação.
 * @param plantedDate Data da plantação.
 * @param harvestDate Data da colheita.
 * @param farmId      "Id" da fazenda proprietária da planatação.
 */
public record CropDto(Long id, String name, Double plantedArea, LocalDate plantedDate,
                      LocalDate harvestDate, Long farmId) {

  /**
   * Método que transforma Entidade em DTO.
   *
   * @param crop Entidade plantação.
   * @return Retorna a plantação no formato de DTO.
   */
  public static CropDto fromEntity(Crop crop) {
    return
        new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getPlantedDate(),
            crop.getHarvestDate(), crop.getFarm().getId());
  }

  /**
   * Método que transforma Dto em entidade.
   *
   * @return Retorna a plantação no formato de entidade.
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
