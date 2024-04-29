package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gift")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {
        java.util.Optional<Person> person = personService.getPersonById(id);
        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(person.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long id,  @RequestBody Person personDetails) {
        personService.updatePerson(id, personDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
