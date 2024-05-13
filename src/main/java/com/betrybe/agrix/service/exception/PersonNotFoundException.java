package com.betrybe.agrix.service.exception;

/**
 * Exception thrown when a Person is not found.
 */
public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
