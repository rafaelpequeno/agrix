package com.betrybe.agrix.service.exception;

/**
 * Exception thrown when a crop is not found.
 */
public class CropNotFoundException extends RuntimeException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
