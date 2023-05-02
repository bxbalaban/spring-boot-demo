package com.bxbalaban.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bxbalaban.demo.dao.PersonDao;
import com.bxbalaban.demo.model.Person;

@Service // also you can use @Component
public class PersonService {
    private final PersonDao personDao; // we are trying to achieve dependency injection by using this here

    @Autowired // we inject, autowiring into PersonDao
    // Because we can implement more than one time we add @Qualifier
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
