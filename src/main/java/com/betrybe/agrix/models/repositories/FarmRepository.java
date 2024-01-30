package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementa a interface JPA para a classe Farm.
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
