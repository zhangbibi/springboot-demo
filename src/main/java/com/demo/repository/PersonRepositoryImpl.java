package com.demo.repository;

import com.demo.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyaping on 20/3/28.
 */

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String, Person> repository = new HashMap<>();

    @Override
    public Person findPerson(String name) {
        return repository.get(name);

    }

    @Override
    public boolean savePerson(Person person) {
        return repository.putIfAbsent(person.getName(), person) == null;
    }
}
