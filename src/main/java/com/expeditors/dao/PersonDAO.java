package com.expeditors.dao;

import com.expeditors.adopter.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
public interface PersonDAO {

    Person insert(Person person);

    boolean update(Person person);

    boolean delete(int id);

    Person findByID(int id);

    boolean findByName(String name);

    Collection<Person> naturalSort();

    List<Person> findAll();

}
