package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Defines a JPA repository interface for the Farm entity.
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
