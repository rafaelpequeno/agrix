package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementa a interface de repository para a entidade de fertilizante.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
