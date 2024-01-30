package com.betrybe.agrix.service.exception;

/**
 * Implementa a FarmNotFoundException.
 */
public class FarmNotFoundException extends RuntimeException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
