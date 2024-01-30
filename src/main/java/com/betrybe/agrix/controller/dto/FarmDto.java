package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * Implementa Dto da fazenda.
 *
 * @param id   "Id" da fazenda.
 * @param name nome da fazenda.
 * @param size tamanho da fazenda.
 */
public record FarmDto(Long id, String name, Double size) {

  /**
   * Transforma a entidade fazenda em Dto.
   *
   * @param farm Entidade Fazenda.
   * @return Retorna um Dto de fazenda.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(), farm.getName(), farm.getSize()
    );
  }

  /**
   * Transforma Dto da fazenda em Entidade.
   *
   * @return Retorna a entidade fazenda.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setId(id);
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
