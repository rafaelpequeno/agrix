package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropCreationDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa o controller para a rota farms.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  FarmService farmService;
  CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  @GetMapping()
  @Secured({"ROLE_ADMIN", "ROLE_USER", "ROLE_MANAGER"})
  public List<FarmDto> getAll() {
    List<Farm> farms = farmService.findAll();
    return farms.stream().map(FarmDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public FarmDto findById(@PathVariable("id") Long id) throws FarmNotFoundException {
    Farm farm = farmService.findById(id);
    return FarmDto.fromEntity(farm);
  }

  @PostMapping()
  public ResponseEntity<FarmDto> create(@RequestBody FarmDto newFarm) {
    Farm farm = farmService.create(newFarm.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(FarmDto.fromEntity(farm));
  }

  @PostMapping("/{id}/crops")
  public ResponseEntity<CropDto> createCrop(@PathVariable("id") Long farmId,
      @RequestBody CropCreationDto newCrop) throws FarmNotFoundException {
    Crop crop = cropService.create(farmId, newCrop.toEntityWithoutFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(CropDto.fromEntity(crop));
  }

  @GetMapping("/{id}/crops")
  public List<CropDto> getCropsByFarmId(@PathVariable("id") Long farmId) {
    return cropService.findByFarmId(farmId).stream().map(CropDto::fromEntity)
        .toList();
  }
}
