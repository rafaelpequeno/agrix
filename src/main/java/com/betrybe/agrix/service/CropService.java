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
 * Implementa a camada de serviço para a entidade Crop.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizerService fertilizerService;

  /**
   * Implementa o contrutor da camada de serviço.
   *
   * @param cropRepository Base de dados da entidade Crop.
   * @param farmService    Camada de serviço da entidade Farm.
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService,
      FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
  }

  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Cria uma nova plantação.
   *
   * @param farmId "Id" da fazenda proprietária da plantação.
   * @param crop   Entidade plantação.
   * @return Retorna a plantação criada.
   * @throws FarmNotFoundException Lança uma excessão caso não encontre a fazenda informada.
   */
  public Crop createCrop(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);
    crop.setFarm(farm);
    return create(crop);
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
   * Implementa a associação entre plantação e fertilizante na camada controller.
   *
   * @param cropId       Id da plantação.
   * @param fertilizerId Id do fertilizante.
   * @return Retorna uma mensagem se a operação for bem sucedida.
   * @throws CropNotFoundException       Lança uma excessão se a fazenda não for encontrada.
   * @throws FertilizerNotFoundException Lança uma excessão se o fertilizante não for encontrado.
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
