package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public void updatePerson(Long id, Person personDetails) {
        Person person = new Person();
        person.setId(id);
        person.setUsername(personDetails.getUsername());
        person.setFirstname(personDetails.getFirstname());
        person.setLastname(personDetails.getLastname());
        person.setUserid(personDetails.getUserid());
        person.setPassword(personDetails.getPassword());
        person.setPhone(personDetails.getPhone());
        person.setEmail(personDetails.getEmail());
        person.setAge(personDetails.getAge());
        person.setGender(personDetails.getGender());
        person.setDob(personDetails.getDob());
    
        personRepository.save(person);
    }
    

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
