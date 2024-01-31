package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropCreationDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.PersonService;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementa o controller para a rota persons.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }


  @PostMapping()
  public ResponseEntity<PersonDto> create(@RequestBody Person newPerson) {
    Person person = personService.create(newPerson);
    return ResponseEntity.status(HttpStatus.CREATED).body(PersonDto.fromEntity(person));
  }

}
