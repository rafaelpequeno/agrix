package com.betrybe.agrix.service.exception;

/**
 * Exception thrown when a Farm is not found.
 */
public class FarmNotFoundException extends RuntimeException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
