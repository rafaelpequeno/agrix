package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Implements the Person DTO.
 *
 * @param id       The Person entity identifier.
 * @param username The Person entity username.
 * @param role     The Person entity role permission.
 */
public record PersonDto(Long id, String username, Role role) {

  public static PersonDto fromEntity(Person person) {
    return new PersonDto(person.getId(), person.getUsername(), person.getRole());
  }

}
