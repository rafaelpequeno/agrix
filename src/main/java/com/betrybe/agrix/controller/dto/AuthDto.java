package com.betrybe.agrix.controller.dto;

/**
 * Implements the authentication DTO.
 *
 * @param username The Person username.
 * @param password The person password.
 */
public record AuthDto(String username, String password) {

}
