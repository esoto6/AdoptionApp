package com.edwinsoto.dao;

import com.edwinsoto.adopter.Adopter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Profile({"dev", "test"})
public class InMemoryDAO implements PersonDAO {
    private Map<Integer, Adopter> persons = new HashMap<>();
    private int nextId = 1;

    @Override
    public Adopter insert(Adopter person) {
        int id = nextId++;
        person.setId(id);
        //person.setName(STR."InMem: \{person.getName()}");
        persons.put(person.getId(), person);
        return person;
    }

    @Override
    public boolean update(Adopter person) {
        return persons.replace(person.getId(), person) != null;
    }

    @Override
    public boolean delete(int id) {
        return persons.remove(id) != null;
    }

    @Override
    public Adopter findByID(int id) {
        return persons.get(id);
    }

    @Override
    public boolean findByName(String name) {
        return persons.values().stream().anyMatch(v -> v.getName().equalsIgnoreCase(name));
    }

    @Override
    public Collection<Adopter> naturalSort() {
        return persons.values().stream().sorted().collect(Collectors.toList());
    }


    @Override
    public List<Adopter> findAll() {
        return new ArrayList<>(persons.values());
    }
}
