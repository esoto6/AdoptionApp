package com.expeditors.dao;

import com.expeditors.adopter.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
@Profile("prod")
@Repository
public class JPA_DAO implements PersonDAO {
    private Map<Integer, Person> persons = new HashMap<>();
    private int nextId = 1;

    @Override
    public Person insert(Person person) {
        int id = nextId++;
        person.setId(id);
        //person.setName(STR."InMem: \{person.getName()}");
        persons.put(person.getId(), person);
        return person;
    }

    @Override
    public boolean update(Person person) {
        return persons.replace(person.getId(), person) != null;
    }

    @Override
    public boolean delete(int id) {
        return persons.remove(id) != null;
    }

    @Override
    public Person findByID(int id) {
        return persons.get(id);
    }

    @Override
    public boolean findByName(String name) {
        return persons.values().stream().anyMatch(v -> v.getName().equalsIgnoreCase(name));

    }

    @Override
    public Collection<Person> naturalSort() {
        return persons.values();
//        return persons.values().stream().sorted().collect(Collectors.toList());
    }

//    @Override
//    public Person findByName(Person person) {
//        return persons.get(person);
//    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons.values());
    }
}
