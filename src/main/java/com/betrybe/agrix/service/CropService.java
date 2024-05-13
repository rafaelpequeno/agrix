package com.betrybe.agrix.service;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements a service layer for the Crop entity.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizerService fertilizerService;


  /**
   * Implements the service layer constructor.
   *
   * @param cropRepository    The repository for accessing Crop entities.
   * @param farmService       The service for managing Farm entities.
   * @param fertilizerService The service for managing Fertilizer entities.
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService,
      FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
  }

  public Crop save(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Create a new Crop.
   *
   * @param farmId The identifier of the Farm entity to which the Crop belongs.
   * @param crop   The Crop entity.
   * @return A new Crop.
   * @throws FarmNotFoundException If the specified Farm is not found.
   */
  public Crop create(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);
    crop.setFarm(farm);
    return save(crop);
  }

  public List<Crop> findByFarmId(Long farmId) {
    Farm farm = farmService.findById(farmId);
    return farm.getCrop();
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long cropId) throws CropNotFoundException {
    Optional<Crop> crop = cropRepository.findById(cropId);
    return crop.orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findByHarvestDate(LocalDate startDate, LocalDate endDate) {
    return cropRepository.findByHarvestDateBetween(startDate, endDate);
  }

  /**
   * Implements the association between Crop and fertilizer.
   *
   * @param cropId       The identifier of the Crop entity.
   * @param fertilizerId The identifier of the Fertilizer entity.
   * @return A success message when completes de association.
   * @throws CropNotFoundException       if the specified Crop is not found.
   * @throws FertilizerNotFoundException if the specified Fertilizer is not found.
   */
  public String addFertilizer(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);
    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);
    return "Fertilizante e plantação associados com sucesso!";
  }
}
