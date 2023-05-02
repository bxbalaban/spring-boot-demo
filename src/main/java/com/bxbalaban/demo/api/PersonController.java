package com.bxbalaban.demo.api;

import org.springframework.beans.factory.annotation.Autowired;

import com.bxbalaban.demo.model.Person;
import com.bxbalaban.demo.service.PersonService;

public class PersonController {
    private final PersonService personService;

    @Autowired // injects the actual service into this constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }

}
