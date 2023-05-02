package com.bxbalaban.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bxbalaban.demo.model.Person;

//we are saying this needs to be initiated first
@Repository("fakeDao") // also can be @Component
// this class will implement PersonDao
public class FakePersonDataAccessService implements PersonDao {

    // a list of Person like a database
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;// we want insertion to be always working
    }

}
