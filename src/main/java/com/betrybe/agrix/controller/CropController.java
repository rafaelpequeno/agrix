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
 * Implements a controller layer for the Crop entity.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

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
   * Implements the association between Crop and Fertilizer.
   *
   * @param cropId       The Crop entity identifier.
   * @param fertilizerId The Fertilizer entity identifier.
   * @return Return a success message.
   * @throws CropNotFoundException       if the specified Crop is not found.
   * @throws FertilizerNotFoundException if the specified Fertilizer is not found.
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
   * Implements the method that retrieves a list of fertilizers used in a specified Crop.
   *
   * @param cropId The Crop entity identifier.
   * @return Return a list of the fertilizers used in a specified Crop.
   * @throws CropNotFoundException if the Crop is not found.
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
