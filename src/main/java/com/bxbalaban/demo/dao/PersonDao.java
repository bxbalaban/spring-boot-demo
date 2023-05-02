package com.bxbalaban.demo.dao;

import java.util.UUID;

import com.bxbalaban.demo.model.Person;

//We are going to define operations allowed for the implementer
public interface PersonDao {
    // create a person with id number
    int insertPerson(UUID id, Person person);

    // create a person without an id
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
