package com.betrybe.agrix.service.exception;

/**
 * Implementa a exceção para fertilizante não encontrado.
 */
public class FertilizerNotFoundException extends RuntimeException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
