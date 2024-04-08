package com.expeditors.dao;

import com.expeditors.adopter.Adopter;

import java.util.Collection;
import java.util.List;
public interface PersonDAO {

    Adopter insert(Adopter person);

    boolean update(Adopter person);

    boolean delete(int id);

    Adopter findByID(int id);

    boolean findByName(String name);

    Collection<Adopter> naturalSort();

    List<Adopter> findAll();

}
