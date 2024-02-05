package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.AuthDto;
import com.betrybe.agrix.controller.dto.TokenDto;
import com.betrybe.agrix.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa a camada controller para autenticação.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  @Autowired
  public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  /**
   * Implementa o método de login da aplicação.
   *
   * @param authDto Dto de autenticação com usuário e senha.
   * @return Retorna um token JWT.
   */
  @PostMapping("/login")
  public TokenDto login(@RequestBody AuthDto authDto) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
        new UsernamePasswordAuthenticationToken(
            authDto.username(), authDto.password());
    Authentication authentication = authenticationManager.authenticate(
        usernamePasswordAuthenticationToken);
    String token = tokenService.generateToken(authentication.getName());
    return new TokenDto(token);
  }
}
