package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Implementa Dto para a entidade Pessoa.
 *
 * @param id       Id da pessoa.
 * @param username Nome de usuário da pessoa.
 * @param role     Tipo de permissões da pessoa.
 */
public record PersonDto(Long id, String username, Role role) {

  public static PersonDto fromEntity(Person person) {
    return new PersonDto(person.getId(), person.getUsername(), person.getRole());
  }

}
