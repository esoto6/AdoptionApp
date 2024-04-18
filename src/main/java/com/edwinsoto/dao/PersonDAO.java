package com.edwinsoto.dao;

import com.edwinsoto.adopter.Adopter;

import java.util.Collection;
import java.util.List;
public interface PersonDAO {

    Adopter insert(Adopter person);

    boolean update(Adopter person);

    boolean delete(int id);

    Adopter findByID(int id);


    List<Adopter> findAll();

}
