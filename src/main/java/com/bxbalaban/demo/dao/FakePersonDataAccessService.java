package com.bxbalaban.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if (person.isEmpty())
            return 0;
        DB.remove(person.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int index = DB.indexOf(person);
                    if (index >= 0) {
                        DB.set(index, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);

    }

}
