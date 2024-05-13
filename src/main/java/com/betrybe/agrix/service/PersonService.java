package com.betrybe.agrix.service;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.models.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implements a service layer for the person entity.
 */
@Service
public class PersonService implements UserDetailsService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonService(
      PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  /**
   * Creates a new person with encrypted password.
   */
  public Person create(Person person) {
    String hashdPassword = new BCryptPasswordEncoder().encode(person.getPassword());
    person.setPassword(hashdPassword);
    return personRepository.save(person);
  }

  /**
   * Implements the method for Spring Security retrieve the user datails.
   *
   * @param username The username identifier of the Person entity.
   * @return The given Person details.
   * @throws UsernameNotFoundException if the specified Person is not found.
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return personRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
