package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Defines a JPA repository interface for the Fertilizer entity.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
