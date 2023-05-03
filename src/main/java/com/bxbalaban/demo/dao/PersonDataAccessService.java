package com.bxbalaban.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bxbalaban.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sqlw = "SELECT id , name FROM person";
      
            Object people = jdbcTemplate.query(sqlw,(resultSet,i)-> {
                String name = resultSet.getString("name");
                UUID id = UUID.fromString(resultSet.getString("id"));
                return new Person(id,name);
            });
            return (List<Person>) people;
        //return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

   

    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertPerson'");
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet,i)-> {
            String name = resultSet.getString("name");
            UUID personId = UUID.fromString(resultSet.getString("id"));
            return new Person(personId,name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePersonById'");
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePersonById'");
    }

}
