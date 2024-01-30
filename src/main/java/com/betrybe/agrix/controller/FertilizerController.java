package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa o serviço de controle da entidade de fertilizantes.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping()
  public ResponseEntity<FertilizerDto> create(@RequestBody FertilizerDto newFertilizer) {
    Fertilizer fertilizer = fertilizerService.create(newFertilizer.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(FertilizerDto.fromEntity(fertilizer));
  }

  @GetMapping()
  public List<FertilizerDto> findAll() {
    List<Fertilizer> fertilizers = fertilizerService.findAll();
    return fertilizers.stream().map(FertilizerDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public FertilizerDto findById(@PathVariable Long id) throws FertilizerNotFoundException {
    Fertilizer fertilizer = fertilizerService.findById(id);
    return FertilizerDto.fromEntity(fertilizer);
  }
}
