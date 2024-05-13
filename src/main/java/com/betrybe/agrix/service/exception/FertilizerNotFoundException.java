package com.betrybe.agrix.service.exception;

/**
 * Exception thrown when a Fertilizer is not found.
 */
public class FertilizerNotFoundException extends RuntimeException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
