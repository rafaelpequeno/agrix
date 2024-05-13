package com.betrybe.agrix.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Implements a service layer for JWT token validation.
 */
@Service
public class TokenService {

  private final Algorithm algorithm;

  public TokenService(@Value("${api.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Implements the JWT token generator method.
   *
   * @param username The Person username.
   * @return returns a JWT token.
   */
  public String generateToken(String username) {
    return JWT.create()
        .withSubject(username)
        .withExpiresAt(generateExpiration())
        .sign(algorithm);
  }

  public Instant generateExpiration() {
    return Instant.now().plus(2, ChronoUnit.HOURS);
  }

  /**
   * Implements the token validation.
   *
   * @param token The JWT token.
   * @return Returns the Person username after the successful token validation.
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }
}
