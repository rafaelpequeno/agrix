package com.betrybe.agrix.controller.dto;

/**
 * Implementa Dto para autenticação.
 *
 * @param username Nome de usuário.
 * @param password Senha do usuário.
 */
public record AuthDto(String username, String password) {

}
