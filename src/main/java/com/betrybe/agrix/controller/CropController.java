package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa a camada de controle para a entidade Crop.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @GetMapping()
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
  public List<CropDto> findAll() {
    return cropService.findAll().stream().map(CropDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public CropDto findById(@PathVariable("id") Long cropId) throws CropNotFoundException {
    Crop crop = cropService.findById(cropId);
    return CropDto.fromEntity(crop);
  }

  @GetMapping("/search")
  public List<CropDto> findByHarvestDate(@RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    List<Crop> crops = cropService.findByHarvestDate(start, end);
    return crops.stream().map(CropDto::fromEntity).toList();
  }

  /**
   * Implementa a associação entre plantação e fertilizante na camada controller.
   *
   * @param cropId       Id da plantação.
   * @param fertilizerId Id do fertilizante.
   * @return Retorna uma mensagem se a operação for bem sucedida.
   * @throws CropNotFoundException       Lança uma excessão se a fazenda não for encontrada.
   * @throws FertilizerNotFoundException Lança uma excessão se o fertilizante não for encontrado.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> addFertilizer(@PathVariable("cropId") Long cropId,
      @PathVariable("fertilizerId") Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    String response = cropService.addFertilizer(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(response);
  }

  /**
   * Implementa o método que retorna os fertilizantes utilizados na plantação com o id
   * correspondente.
   *
   * @param cropId Id da plantação.
   * @return Retorna uma lista com os fertilizantes da plantação.
   * @throws CropNotFoundException Lança uma excessão quando não encontra a plantação.
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> findCropFertilizers(
      @PathVariable("cropId") Long cropId)
      throws CropNotFoundException {
    Crop crop = cropService.findById(cropId);
    List<FertilizerDto> cropFertilizers = FertilizerDto.fromEntities(crop.getFertilizers());
    return ResponseEntity.status(HttpStatus.OK).body(cropFertilizers);
  }
}
