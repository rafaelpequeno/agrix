package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Fertilizer;
import java.util.List;

/**
 * Implementa Dto da entidade de fertilizantes.
 *
 * @param id          Id do fertilizante.
 * @param name        Nome do fertilizante.
 * @param brand       Marca do fertilizante.
 * @param composition Composição do fertilizante.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {

  /**
   * Transforma a entidade fertilizante em um DTO.
   *
   * @param fertilizer Entidade de fertilizante.
   * @return Retorna um Dto da entidade de fertilizante.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(fertilizer.getId(), fertilizer.getName(), fertilizer.getBrand(),
        fertilizer.getComposition());
  }

  /**
   * Transforma um DTO de fertilizante em entidade.
   *
   * @return Retorna uma entidade de fertilizante.
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
   * Implementa o método que transforma uma lista de entidades fertilizante em uma lista de dto.
   *
   * @param fertilizers Recebe uma lista de entidades do tipo fertilizante.
   * @return Retorna uma lista de Dto da entidade fertilizante.
   */
  public static List<FertilizerDto> fromEntities(List<Fertilizer> fertilizers) {
    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

}
