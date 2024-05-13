package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Defines a JPA repository interface for the Crop entity.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

  /**
   * Retrieves a list of crops with harvest dates between the given start and end dates.
   *
   * @param startDate The start date of the harvest period.
   * @param endDate   The end date of the harvest period.
   * @return A list of crops with harvest dates between the start and end dates.
   */
  List<Crop> findByHarvestDateBetween(LocalDate startDate, LocalDate endDate);
}
