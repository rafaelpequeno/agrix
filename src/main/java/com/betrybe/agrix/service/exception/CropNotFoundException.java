package com.betrybe.agrix.service.exception;

/**
 * Implementa excessão para plantação não encontrada.
 */
public class CropNotFoundException extends RuntimeException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
