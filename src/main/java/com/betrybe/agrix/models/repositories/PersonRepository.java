package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Defines a JPA repository interface for the Person entity.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

  /**
   * Retrieves a person by their username.
   *
   * @param username The username of the person to retrieve.
   * @return An Optional containing the person if found, otherwise empty.
   */
  Optional<Person> findByUsername(String username);
}
