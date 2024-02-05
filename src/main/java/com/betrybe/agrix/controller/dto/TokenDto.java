package com.betrybe.agrix.controller.dto;

/**
 * Implementa Dto para retornar o token do usuário autenticado.
 *
 * @param token Token JWT.
 */
public record TokenDto(String token) {

}
