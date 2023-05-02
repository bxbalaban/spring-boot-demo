package com.bxbalaban.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bxbalaban.demo.model.Person;
import com.bxbalaban.demo.service.PersonService;

@RestController // we can provide end points to clients and consume
@RequestMapping("api/v1/person")

// post get delete must be available as a rest controller
public class PersonController {
    private final PersonService personService;

    @Autowired // injects the actual service into this constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping // will serve as a post method
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

}
